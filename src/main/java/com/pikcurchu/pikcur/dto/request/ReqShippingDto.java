package com.pikcurchu.pikcur.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ReqShippingDto {
    private Integer transactionId;
    private String trackingNumber;
    private String company;
}
