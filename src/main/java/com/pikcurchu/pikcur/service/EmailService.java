package com.pikcurchu.pikcur.service;

import com.pikcurchu.pikcur.common.ApiResponse;
import com.pikcurchu.pikcur.common.ResponseCode;
import com.pikcurchu.pikcur.mapper.EmailMapper;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletResponse;
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

    public ApiResponse<Void> sendVerificationCode(String email) {
        if (selectEmail(email)) {
            return ApiResponse.fail(
                    ResponseCode.DUPLICATE.getCode(),
                    ResponseCode.DUPLICATE.getMessage(),
                    HttpServletResponse.SC_CONFLICT
            );
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
            return ApiResponse.success(null);
        } catch (MessagingException e) {
            e.printStackTrace();
            return ApiResponse.fail(
                    ResponseCode.MAIL_SEND_FAIL.getCode(),
                    ResponseCode.MAIL_SEND_FAIL.getMessage(),
                    HttpServletResponse.SC_INTERNAL_SERVER_ERROR
            );
        }
    }

    public ApiResponse<Void> verifyCode(String email, String inputCode) {
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        String savedCode = ops.get("auth:" + email);

        if (savedCode == null) {
            return ApiResponse.fail(
                    ResponseCode.EXPIRATION.getCode(),
                    ResponseCode.EXPIRATION.getMessage(),
                    HttpServletResponse.SC_BAD_REQUEST
            );
        }

        if (!savedCode.equals(inputCode)) {
            return ApiResponse.fail(
                    ResponseCode.INCONSISTENCY.getCode(),
                    ResponseCode.INCONSISTENCY.getMessage(),
                    HttpServletResponse.SC_BAD_REQUEST
            );
        }

        return ApiResponse.success(null);
    }

    public boolean selectEmail(String email) {
        return emailMapper.countByEmail(email) > 0;
    }
}
