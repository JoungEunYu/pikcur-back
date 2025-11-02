package com.pikcurchu.pikcur.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Answer {
    private Integer answerId;
    private Integer questionId;
    private Integer memberNo;
    private String title;
    private String content;
    private String imagePath;
    private LocalDateTime createDate;
}
