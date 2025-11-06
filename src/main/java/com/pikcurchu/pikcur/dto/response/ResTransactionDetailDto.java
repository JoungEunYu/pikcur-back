package com.pikcurchu.pikcur.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResTransactionDetailDto {
    private Integer transactionId;
    private LocalDateTime createDate;
    private String statusName;
    private Integer goodsId;
    private String goodsName;
    private String goodsImage;
    private SellerInfo sellerInfo; /* 상점명, 연락처*/
    private BuyerInfo buyerInfo; /* 이름, 주소, 연락처, 운송장 번호*/
    private PaymentInfo paymentInfo; /*낙찰가, 배송비, 결제수단, 결제금액*/




}