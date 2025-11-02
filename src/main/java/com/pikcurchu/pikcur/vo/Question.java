package com.pikcurchu.pikcur.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    private Integer questionId;
    private Integer memberNo;
    private Integer goodsId;
    private String title;
    private String content;
    private String imagePath;
    private LocalDateTime createDate;
}
