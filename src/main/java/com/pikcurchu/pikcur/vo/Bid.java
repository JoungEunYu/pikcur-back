package com.pikcurchu.pikcur.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bid {

    private Integer bidId;
    private Integer memberNo;
    private Integer goodsId;
    private Integer bidPrice;
    private java.sql.Timestamp createDate;
    private String statusType;
    private String statusNo;
}
