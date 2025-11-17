package com.pikcurchu.pikcur.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class ResGoodsBidsPageDto {
    private List<ResGoodsBidItemDto> bidList;
    private int totalPages;
    private int totalCount;
}
