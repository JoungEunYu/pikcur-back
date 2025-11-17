package com.pikcurchu.pikcur.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private Integer accountId;
    private Integer memberNo;
    private String bank;
    private String accountNumber;
    private String name;
    private String isDefault;
}
