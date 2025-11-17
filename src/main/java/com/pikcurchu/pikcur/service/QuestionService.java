package com.pikcurchu.pikcur.service;

import com.pikcurchu.pikcur.dto.request.ReqAnswerDto;
import com.pikcurchu.pikcur.dto.request.ReqQuestionDto;
import com.pikcurchu.pikcur.dto.response.ResQuestionDetailDto;
import com.pikcurchu.pikcur.mapper.ImageMapper;
import com.pikcurchu.pikcur.mapper.QuestionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionMapper questionMapper;
    private final ImageMapper imageMapper;
    private final FileService fileService;

    public Integer insertQuestion(ReqQuestionDto questionDto, Integer memberNo) {
        questionDto.setMemberNo(memberNo);
        questionMapper.insertQuestion(questionDto);

        return questionDto.getQuestionId();
    }

    public Integer insertAnswer(Integer questionId, ReqAnswerDto answerDto, Integer memberNo) {
        answerDto.setMemberNo(memberNo);
        answerDto.setQuestionId(questionId);
        questionMapper.insertAnswer(answerDto);

        return answerDto.getAnswerId();
    }

    public ResQuestionDetailDto selectQuestionDetail(Integer questionId) {
        return questionMapper.findQuestionDetailById(questionId);
    }

    public void insertQuestionImage(Integer questionId, MultipartFile image) {
        String uploadedPath = fileService.questionUploadFile(image);
        questionMapper.updateQuestionImagePath(questionId, uploadedPath);
    }

    public void insertAnswerImage(Integer answerId, MultipartFile image) {
        String uploadedPath = fileService.answerUploadFile(image);
        questionMapper.updateAnswerImagePath(answerId, uploadedPath);
    }
}
