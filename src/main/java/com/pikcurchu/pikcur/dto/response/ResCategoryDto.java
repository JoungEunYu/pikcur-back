package com.pikcurchu.pikcur.dto.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class ResCategoryDto {
    private Integer categoryId;
    private String categoryName;
    private List<SubCategoryDto> subCategories;
}
