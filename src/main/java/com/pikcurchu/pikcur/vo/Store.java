package com.pikcurchu.pikcur.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Store {

    private Integer storeId;
    private Integer memberNo;
    private String profile;
    private String storeName;
    private String storeInfo;
}
