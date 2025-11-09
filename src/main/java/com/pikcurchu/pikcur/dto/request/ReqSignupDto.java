package com.pikcurchu.pikcur.dto.request;

import com.pikcurchu.pikcur.enums.Authority;
import com.pikcurchu.pikcur.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReqSignupDto {
    private String id;
    private String password;
    private String email;
    private String name;
    private String phone;
    private Gender gender;
    private LocalDate birth;
}
