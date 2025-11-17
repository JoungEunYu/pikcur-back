package com.pikcurchu.pikcur.vo;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {
//    private Integer paymentId;
    private String paymentId;
    private Integer transactionId;
    private String paymentMethod;
    private Integer paymentPrice;
    private LocalDateTime createDate;
    private String statusType;
    private String statusNo;
}
