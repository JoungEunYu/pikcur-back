package com.pikcurchu.pikcur.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class ResBidsPageDto {
    private List<ResBidItemDto> bidList;
    private int totalPages;
    private int totalCount;
}
