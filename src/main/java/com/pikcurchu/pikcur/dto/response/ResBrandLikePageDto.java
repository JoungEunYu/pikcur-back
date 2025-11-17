package com.pikcurchu.pikcur.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResBrandLikePageDto {
    private List<ResBrandItemDto> brandLikeList;
    private int totalPages;
    private int totalCount;
}
