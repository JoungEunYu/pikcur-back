package com.pikcurchu.pikcur.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResQuestionDetailDto {
    private Integer questionId;
    private Integer memberNo; /* 등록한 회원*/
    private Integer storeId; /* 받은 회원 */
    private String title;
    private String content;
    private String imagePath;
    private AnswerInfo answerInfo;
}
