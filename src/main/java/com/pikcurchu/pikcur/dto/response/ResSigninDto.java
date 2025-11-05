package com.pikcurchu.pikcur.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResSigninDto {
    private String token;      // JWT 토큰
    private Integer memberNo;  // 회원 번호
    private String id;         // 회원 아이디
    private String name;       // 이름
    private String authority;  // 권한
}