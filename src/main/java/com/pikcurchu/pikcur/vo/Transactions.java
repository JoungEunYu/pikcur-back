package com.pikcurchu.pikcur.vo;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transactions {
    private Integer transactionId;
    private Integer buyerNo;
    private Integer sellerNo;
    private Integer goodsId;
    private Integer price;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String useYn;
    private String statusType;
    private String statusNo;
    private String trackingNumber;
}
