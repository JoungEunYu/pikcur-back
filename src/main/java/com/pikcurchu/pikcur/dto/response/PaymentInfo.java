package com.pikcurchu.pikcur.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentInfo {
    private Integer paymentPrice;
    private String paymentMethod;
    private Integer bidPrice;
    private Integer shippingPrice;
}