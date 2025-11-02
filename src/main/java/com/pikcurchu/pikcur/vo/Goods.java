package com.pikcurchu.pikcur.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {

    private Integer goodsId;
    private Integer storeId;
    private Integer categoryId;
    private Integer brandId;
    private String goodsName;
    private String goodsInfo;
    private Integer buyoutPrice;
    private Integer startPrice;
    private Integer shippingPrice;
    private LocalDateTime auctionEndDate;
    private String quality;
    private String size;
    private String statusType;
    private String statusNo;
    private Integer views;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
