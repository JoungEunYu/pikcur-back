package com.pikcurchu.pikcur.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResGoodsPageDto {
    private List<ResGoodsItemDto> goodsList;
    private int totalPages;
    private int totalCount;
}
