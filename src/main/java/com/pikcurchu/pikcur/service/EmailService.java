package com.pikcurchu.pikcur.service;

import com.pikcurchu.pikcur.mapper.EmailMapper;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
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
    private final EmailMapper emailMapper;

    public EmailService(JavaMailSender mailSender, StringRedisTemplate redisTemplate, EmailMapper emailMapper) {
        this.mailSender = mailSender;
        this.redisTemplate = redisTemplate;
        this.emailMapper = emailMapper;
    }

    private String createCode() {
        Random random = new Random();
        int code = random.nextInt(900000) + 100000;
        return String.valueOf(code);
    }

    public boolean sendVerificationCode(String email) {
        if (selectEmail(email)) {
            return false;
        }

        String code = createCode();

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

    public boolean selectEmail(String email) {
        return emailMapper.countByEmail(email) > 0;
    }
}
