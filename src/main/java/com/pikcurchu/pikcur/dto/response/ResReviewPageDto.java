package com.pikcurchu.pikcur.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class ResReviewPageDto {
    private List<ResReviewItemDto> reviewList;
    private int totalPages;
    private int totalCount;
}
