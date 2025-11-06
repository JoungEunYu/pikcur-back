package com.pikcurchu.pikcur.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuyerInfo {
    private String name;
    private String phone;
    private String trackingNumber;
    private String company;
    private String address;
    private String addressDetail;
}