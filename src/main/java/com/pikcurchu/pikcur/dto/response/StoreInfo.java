package com.pikcurchu.pikcur.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class StoreInfo {
    private Integer storeId;
    private String storeName;
    private String imagePath;
    private Double averageRating;
    private Integer reviewCount;
}
