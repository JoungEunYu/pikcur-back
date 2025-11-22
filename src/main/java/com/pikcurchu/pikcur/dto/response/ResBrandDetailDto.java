package com.pikcurchu.pikcur.dto.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ResBrandDetailDto {
    private Integer brandId;
    private String brandName;
    private String brandProfile;
    private String brandInfo;
    private boolean isLiked;
    private Integer goodsCount;
}
