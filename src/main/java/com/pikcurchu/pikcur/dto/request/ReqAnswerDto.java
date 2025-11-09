package com.pikcurchu.pikcur.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ReqAnswerDto {
    private Integer questionId;
    private Integer memberNo;
    private String title;
    private String content;
    private String imagePath;
}
