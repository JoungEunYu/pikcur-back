package com.pikcurchu.pikcur.dto.request;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Data
@RequiredArgsConstructor
public class ReqReviewDto {
    private Integer reviewId;
    private Integer memberNo;
    private Integer storeId;
    private Integer rating;
    private String content;
    private List<Integer> choiceIds;
}