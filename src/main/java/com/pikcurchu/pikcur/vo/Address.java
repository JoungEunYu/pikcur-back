package com.pikcurchu.pikcur.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private Integer addressId;
    private Integer memberNo;
    private String name;
    private String phone;
    private String address;
    private String addressDetail;
    private String isDefault;
    private String useYn;
}
