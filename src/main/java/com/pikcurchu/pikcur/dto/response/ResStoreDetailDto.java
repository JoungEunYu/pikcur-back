package com.pikcurchu.pikcur.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResStoreDetailDto {
    private Integer storeId;
    private String profile;
    private String storeName;
    private String storeInfo;
    private float rating;
    private Integer reviewCount;
    private Integer followerCount;
    private boolean isFollow;

}
