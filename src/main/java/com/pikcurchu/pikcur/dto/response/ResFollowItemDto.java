package com.pikcurchu.pikcur.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ResFollowItemDto {
    private Integer storeId;
    private String profile;
    private String storeName;
    private boolean isFollow;
}
