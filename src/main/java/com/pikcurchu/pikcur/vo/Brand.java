package com.pikcurchu.pikcur.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Brand {

    private Integer brandId;
    private String brandName;
    private String brandProfile;
    private String brandInfo;
}
