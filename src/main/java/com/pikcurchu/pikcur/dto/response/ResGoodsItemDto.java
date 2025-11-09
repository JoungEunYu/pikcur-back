package com.pikcurchu.pikcur.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResGoodsItemDto {
    private Integer goodsId;
    private Integer categoryId;
    private Integer brandId;
    private String goodsName;
    private Integer buyoutPrice;
    private Integer startPrice;
    private LocalDateTime auctionEndDate;
    private LocalDateTime createDate;
    private Integer bidCount;
    private boolean isLike;
    private String statusName;

}
