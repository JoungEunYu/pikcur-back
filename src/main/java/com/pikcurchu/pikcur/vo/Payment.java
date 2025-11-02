package com.pikcurchu.pikcur.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    private Integer paymentId;
    private Integer transactionId;
    private String paymentMethod;
    private Integer paymentPrice;
    private LocalDateTime createDate;
    private String statusType;
    private String statusNo;
}
