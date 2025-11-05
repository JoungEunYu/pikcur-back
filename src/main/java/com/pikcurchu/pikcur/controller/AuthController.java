package com.pikcurchu.pikcur.controller;

import com.pikcurchu.pikcur.dto.request.ReqSigninDto;
import com.pikcurchu.pikcur.dto.response.ResSigninDto;
import com.pikcurchu.pikcur.jwt.JwtUtil;
import com.pikcurchu.pikcur.service.SigninService;
import com.pikcurchu.pikcur.vo.Member;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name="login api", description = "로그인 api")
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final SigninService signinService;

    public AuthController(SigninService signinService) {
        this.signinService = signinService;
    }

    @Operation(summary = "로그인", description = "JWT 토큰 방식 로그인")
    @PostMapping("/signin")
    public ResponseEntity<ResSigninDto> login(@RequestBody ReqSigninDto loginDto) {
        Member member = signinService.authenticate(loginDto.getId(), loginDto.getPassword());
        if(member != null) {
            String token = JwtUtil.generateToken(member.getId());
            ResSigninDto response = new ResSigninDto(
                    token,
                    member.getMemberNo(),
                    member.getId(),
                    member.getName(),
                    member.getAuthority()
            );
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
