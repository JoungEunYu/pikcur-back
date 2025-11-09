package com.pikcurchu.pikcur.controller;

import com.pikcurchu.pikcur.dto.request.ReqEmailDto;
import com.pikcurchu.pikcur.dto.response.ResSigninDto;
import com.pikcurchu.pikcur.service.EmailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Tag(name="email api", description = "이메일 관련 api")
@RestController
@RequestMapping("/auth")
public class EmailController {
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @Operation(summary = "인증번호 요청 API", description = "인증번호 발송 요청")
    @PostMapping("/email/send-code")
    public ResponseEntity<Boolean> sendCode(@RequestBody ReqEmailDto reqEmailDto) {
        String email = reqEmailDto.getEmail();

        boolean response = emailService.sendVerificationCode(email);

        return new ResponseEntity<Boolean>(response, HttpStatus.OK);
    }

    @Operation(summary = "인증번호 검증 API", description = "이메일과 입력한 인증번호 검증")
    @PostMapping("/email/verify-code")
    public ResponseEntity<Boolean> verifyCode(@RequestBody ReqEmailDto reqEmailDto) {
        boolean response = emailService.verifyCode(reqEmailDto.getEmail(), reqEmailDto.getCode());

        return new ResponseEntity<Boolean>(response, HttpStatus.OK);
    }
}
