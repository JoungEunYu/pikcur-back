package com.pikcurchu.pikcur.vo;

import com.pikcurchu.pikcur.enums.Authority;
import com.pikcurchu.pikcur.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    private Integer memberNo;
    private String id;
    private String password;
    private String name;
    private String email;
    private String phone;
    private LocalDate birth;
    private Gender gender;
    private Authority authority;
    private String statusType;
    private String statusNo;
    private LocalDateTime loginDate;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private String account;
    private String bank;
    private String blockList;
}
