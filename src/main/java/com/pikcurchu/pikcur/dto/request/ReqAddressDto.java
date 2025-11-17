package com.pikcurchu.pikcur.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ReqAddressDto {
    private String name;
    private String phone;
    private String address;
    private String addressDetail;
    private Integer addressId;
}
