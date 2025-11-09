package com.pikcurchu.pikcur.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReqEmailDto {
    private String email;
    private String code;
}
