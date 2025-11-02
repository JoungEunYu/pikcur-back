package com.pikcurchu.pikcur.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transactions {
    private Integer transactionId;
    private Integer buyerNo;
    private Integer goodsId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String useYn;
    private String statusType;
    private String statusNo;
}
