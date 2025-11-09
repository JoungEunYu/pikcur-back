package com.pikcurchu.pikcur.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class QuestionInfo {
    private Integer questionId;
    private boolean isAnswer;
    private String title;
    private boolean isPublic;
    private LocalDateTime createDate;
}
