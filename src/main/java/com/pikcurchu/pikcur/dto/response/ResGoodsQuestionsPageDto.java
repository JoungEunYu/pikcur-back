package com.pikcurchu.pikcur.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResGoodsQuestionsPageDto {
    private List<ResGoodsQuestionsDto> questionList;
    private int totalPages;
    private int totalCount;
}
