package com.pikcurchu.pikcur.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResMyStoreDto {
    private Integer storeId;
    private String profile;
    private String storeName;
    private String storeInfo;
}
