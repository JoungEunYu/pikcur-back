package com.pikcurchu.pikcur.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ReqQuestionDto {
    private Integer goodsId;
    private Integer memberNo;
    private String title;
    private String content;
    private String imagePath;
    private String isPublic;
}
