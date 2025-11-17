package com.pikcurchu.pikcur.dto.request;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class ReqGoodsDto {
    private Integer goodsId;
    private Integer memberNo;
    private Integer categoryId;
    private Integer brandId;
    private String gender;
    private String goodsName;
    private String goodsInfo;
    private Integer buyoutPrice;
    private Integer startPrice;
    private Integer shippingPrice;
    private LocalDateTime auctionEndDate;
    private String quality;
    private String size;
}
