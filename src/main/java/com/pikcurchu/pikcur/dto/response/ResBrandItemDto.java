package com.pikcurchu.pikcur.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ResBrandItemDto {
    private Integer brandId;
    private String brandName;
    private String brandProfile;
    private boolean isLike;
}
