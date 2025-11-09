package com.pikcurchu.pikcur.dto.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class SubCategoryDto {
    private Integer categoryId;
    private String categoryName;
}
