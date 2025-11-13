package com.pikcurchu.pikcur.controller;

import com.pikcurchu.pikcur.dto.request.ReqAnswerDto;
import com.pikcurchu.pikcur.dto.request.ReqQuestionDto;
import com.pikcurchu.pikcur.dto.response.ResQuestionDetailDto;
import com.pikcurchu.pikcur.dto.response.ResStoreDetailDto;
import com.pikcurchu.pikcur.service.QuestionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name="question api", description = "문의 관련 api")
@RequestMapping("/question")
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    @Operation(summary = "문의 등록", description = "문의 객체를 받아 등록")
    @PostMapping
    public ResponseEntity<Void> insertQuestion(@RequestBody ReqQuestionDto questionDto, HttpServletRequest request) {
        Integer memberNo = (Integer) request.getAttribute("memberNo");
        questionService.insertQuestion(questionDto, memberNo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "답변 등록", description = "답변 객체를 받아 등록")
    @PostMapping("/{questionId}/answer")
    public ResponseEntity<Void> insertAnswer(@PathVariable Integer questionId, @RequestBody ReqAnswerDto answerDto, HttpServletRequest request) {
        Integer memberNo = (Integer) request.getAttribute("memberNo");
        questionService.insertAnswer(questionId, answerDto, memberNo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "문의 상세 내역 조회", description = "문의 아이디를 통해 상세 내용을 조회")
    @GetMapping("/{questionId}")
    public ResponseEntity<ResQuestionDetailDto> selectQuestionDetail(@PathVariable Integer questionId) {
        ResQuestionDetailDto question = questionService.selectQuestionDetail(questionId);
        return new ResponseEntity<>(question, HttpStatus.OK);
    }



}
