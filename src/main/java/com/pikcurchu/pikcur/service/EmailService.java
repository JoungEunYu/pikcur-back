package com.pikcurchu.pikcur.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class EmailService {
    private final JavaMailSender mailSender;
    private final StringRedisTemplate redisTemplate;

    public EmailService(JavaMailSender mailSender, StringRedisTemplate redisTemplate) {
        this.mailSender = mailSender;
        this.redisTemplate = redisTemplate;
    }

    private String createCode() {
        Random random = new Random();
        int code = random.nextInt(900000) + 100000; // 100000 ~ 999999
        return String.valueOf(code);
    }

    public boolean sendVerificationCode(String email) {
        String code = createCode();

        // Redis에 3분 TTL로 저장
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        ops.set("auth:" + email, code, 3, TimeUnit.MINUTES);

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setTo(email);
            helper.setSubject("Pikcur 이메일 인증번호");
            helper.setText("<p>인증번호는 <b>" + code + "</b> 입니다.</p>", true);
            mailSender.send(message);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean verifyCode(String email, String inputCode) {
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        String savedCode = ops.get("auth:" + email);

        return savedCode != null && savedCode.equals(inputCode);
    }
}
