package com.pikcurchu.pikcur.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResStoreAverageDto {
    private Integer storeId;
    private String storeName;
    private float averRating;
}
