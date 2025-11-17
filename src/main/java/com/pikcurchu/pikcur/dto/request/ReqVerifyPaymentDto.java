package com.pikcurchu.pikcur.dto.request;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@RequiredArgsConstructor
public class ReqVerifyPaymentDto {
    private String impUid; //결제건의 상세정보를 Iamport 서버에서 가져올 때 쓰는 키
    private String merchantUid;//상점(우리 서버)에서 생성한 주문번호
    private BigDecimal amount;
    private Integer goodsId;
}
