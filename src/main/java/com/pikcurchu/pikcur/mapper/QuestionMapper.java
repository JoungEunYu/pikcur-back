package com.pikcurchu.pikcur.mapper;

import com.pikcurchu.pikcur.dto.request.ReqAnswerDto;
import com.pikcurchu.pikcur.dto.request.ReqQuestionDto;
import com.pikcurchu.pikcur.dto.response.ResQuestionDetailDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestionMapper {
    void insertQuestion(ReqQuestionDto questionDto);

    void insertAnswer(ReqAnswerDto answerDto);

    ResQuestionDetailDto findQuestionDetailById(Integer questionId);

    void updateQuestionImagePath(Integer questionId, String uploadedPath);

    void updateAnswerImagePath(Integer answerId, String uploadedPath);
}
