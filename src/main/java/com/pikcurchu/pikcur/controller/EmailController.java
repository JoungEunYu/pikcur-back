package com.pikcurchu.pikcur.controller;

import com.pikcurchu.pikcur.common.ApiResponse;
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
    public ResponseEntity<ApiResponse<Void>> sendCode(@RequestBody ReqEmailDto reqEmailDto) {
        String email = reqEmailDto.getEmail();

        ApiResponse<Void> response = emailService.sendVerificationCode(email);

        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @Operation(summary = "인증번호 검증 API", description = "이메일과 입력한 인증번호 검증")
    @PostMapping("/email/verify-code")
    public ResponseEntity<ApiResponse<Void>> verifyCode(@RequestBody ReqEmailDto reqEmailDto) {
        ApiResponse<Void> response = emailService.verifyCode(reqEmailDto.getEmail(), reqEmailDto.getCode());

        return ResponseEntity.status(response.getHttpStatus()).body(response); // 상태코드 세팅 (이렇게 안쓰면 에러 떠도 200)
    }
}
