package com.pikcurchu.pikcur.service;

import com.pikcurchu.pikcur.dto.request.ReqAnswerDto;
import com.pikcurchu.pikcur.dto.request.ReqQuestionDto;
import com.pikcurchu.pikcur.dto.response.ResQuestionDetailDto;
import com.pikcurchu.pikcur.mapper.QuestionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionMapper questionMapper;

    public void insertQuestion(ReqQuestionDto questionDto, Integer memberNo) {
        questionDto.setMemberNo(memberNo);
        questionMapper.insertQuestion(questionDto);
    }

    public void insertAnswer(Integer questionId, ReqAnswerDto answerDto, Integer memberNo) {
        answerDto.setMemberNo(memberNo);
        answerDto.setQuestionId(questionId);
        questionMapper.insertAnswer(answerDto);
    }

    public ResQuestionDetailDto selectQuestionDetail(Integer questionId) {
        return questionMapper.findQuestionDetailById(questionId);
    }
}
