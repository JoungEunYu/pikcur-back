package com.pikcurchu.pikcur.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ReqAccountDto {
    private Integer accountId;
    private String bank;
    private String accountNumber;
    private String name;
}
