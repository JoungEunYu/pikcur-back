package com.pikcurchu.pikcur.controller;

import com.pikcurchu.pikcur.dto.request.ReqSigninDto;
import com.pikcurchu.pikcur.dto.request.ReqSignupDto;
import com.pikcurchu.pikcur.dto.response.ResSigninDto;
import com.pikcurchu.pikcur.util.JwtUtil;
import com.pikcurchu.pikcur.service.AuthService;
import com.pikcurchu.pikcur.vo.Member;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name="auth api", description = "인증 관련 API")
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @Operation(summary = "로그인", description = "JWT 토큰 방식 로그인")
    @PostMapping("/members/signin")
    public ResponseEntity<ResSigninDto> signin(@RequestBody ReqSigninDto loginDto) {
        Member member = authService.authenticate(loginDto.getId(), loginDto.getPassword());
        if(member != null) {
            String token = JwtUtil.generateToken(member.getId());
            ResSigninDto response = new ResSigninDto(
                    token,
                    member.getMemberNo(),
                    member.getId(),
                    member.getName(),
                    member.getAuthority()
            );
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @Operation(summary = "회원가입", description = "회원가입 API")
    @PostMapping("/members/signup")
    public ResponseEntity<Integer> signup(@RequestBody ReqSignupDto signupDto) {
        int response = authService.insertMember(signupDto.getId()
                , signupDto.getPassword()
                , signupDto.getEmail()
                , signupDto.getName()
                , signupDto.getPhone()
                , signupDto.getGender()
                , signupDto.getBirth());

        return new ResponseEntity<Integer>(response, HttpStatus.OK);
    }
}
