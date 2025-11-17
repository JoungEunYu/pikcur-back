package com.pikcurchu.pikcur.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResQuestionPageDto {
    private List<ResQuestionItemDto> qnaList;
    private int totalPages;
    private int totalCount;
}
