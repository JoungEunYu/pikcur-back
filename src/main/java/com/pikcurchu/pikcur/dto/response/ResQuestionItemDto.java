package com.pikcurchu.pikcur.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ResQuestionItemDto {
    private Integer memberNo; /* 등록한 회원*/
    private Integer storeId; /* 받은 회원 */
    private Integer questionId;
    private String title;
    private LocalDateTime createDate;
    private boolean isAnswer;
}
