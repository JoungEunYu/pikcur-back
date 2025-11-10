package com.pikcurchu.pikcur.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyPageInfoDto {
    private String name;
    private String email;
    private String phone;
    private LocalDate birth;
}
