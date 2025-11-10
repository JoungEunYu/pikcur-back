package com.pikcurchu.pikcur.controller;

import com.pikcurchu.pikcur.dto.response.ResSigninDto;
import com.pikcurchu.pikcur.util.JwtUtil;
import com.pikcurchu.pikcur.service.AuthService;
import com.pikcurchu.pikcur.vo.Member;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
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
    public ResponseEntity<ResSigninDto> signin(@RequestBody Member member) {
        Member memberDetail = authService.authenticate(member.getId(), member.getPassword());
        if(memberDetail != null) {
            String token = JwtUtil.generateToken(memberDetail.getMemberNo());
            ResSigninDto response = new ResSigninDto(
                    token,
                    memberDetail.getId(),
                    memberDetail.getName(),
                    memberDetail.getAuthority()
            );
            return new ResponseEntity<ResSigninDto>(response, HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @Operation(summary = "회원가입", description = "회원가입 API")
    @PostMapping("/members/signup")
    public ResponseEntity<Integer> signup(@RequestBody Member member) {
        int response = authService.insertMember(member.getId()
                , member.getPassword()
                , member.getEmail()
                , member.getName()
                , member.getPhone()
                , member.getGender()
                , member.getBirth());

        return new ResponseEntity<Integer>(response, HttpStatus.OK);
    }

    @Operation(summary = "아이디 조회", description = "아이디 조회 API")
    @PostMapping("/members/find-id")
    public ResponseEntity<String> findIdByEmail(@RequestBody Member member) {
        String response = authService.findIdByEmail(member.getEmail());

        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    @Operation(summary = "계정 삭제", description = "계정 삭제 API")
    @PutMapping("/members/delete-account")
    public ResponseEntity<Boolean> updateMemberToWithdrawal(HttpServletRequest request) {
        Integer memberNo = (Integer) request.getAttribute("memberNo");

        if (memberNo <= 0) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        Boolean response = authService.updateMemberToWithdrawal(memberNo);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(summary = "아이디 중복", description = "아이지 중복 체크 API")
    @PostMapping("/members/duplicate-id")
    public ResponseEntity<Integer> selectId(@RequestBody Member member) {
        int response = authService.countById(member.getId());

        return new ResponseEntity<Integer>(response, HttpStatus.OK);
    }

    @Operation(summary = "비밀번호 변경", description = "비밀번호 변경 API")
    @PostMapping("/members/password")
    public ResponseEntity<Integer> updatePassword(@RequestBody Member member, HttpServletRequest request) {
        Integer memberNo = (Integer) request.getAttribute("memberNo");

        if (memberNo <= 0) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(0);
        }

        int response = authService.updatePassword(memberNo, member.getPassword());
        if (response > 0) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}
