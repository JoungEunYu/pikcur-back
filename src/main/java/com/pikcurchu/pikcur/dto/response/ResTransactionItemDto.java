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
public class ResTransactionItemDto {
    private Integer transactionId;
    private Integer buyerNo;
    private Integer sellerNo;
    private Integer goodsId;
    private String goodsName;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String statusName;
    private Integer price;
}
