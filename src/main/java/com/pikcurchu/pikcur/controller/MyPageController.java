package com.pikcurchu.pikcur.controller;

import com.pikcurchu.pikcur.dto.response.MyPageInfoDto;
import com.pikcurchu.pikcur.service.MyPageService;
import com.pikcurchu.pikcur.vo.Member;
import com.pikcurchu.pikcur.vo.Store;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name="mypage api", description = "마이페이지 관련 API")
@RestController
@RequestMapping("/mypage")
public class MyPageController {
    private final MyPageService myPageService;

    public MyPageController(MyPageService myPageService) {
        this.myPageService = myPageService;
    }

    @Operation(summary = "내정보 조회", description = "내 정보 조회 API")
    @GetMapping("/profile")
    public ResponseEntity<MyPageInfoDto> selectMyInfoById(HttpServletRequest request) {
        Integer memberNo = (Integer) request.getAttribute("memberNo");

        if (memberNo <= 0) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        MyPageInfoDto response = myPageService.selectMyInfoById(memberNo);

        return new ResponseEntity<MyPageInfoDto>(response, HttpStatus.OK);
    }

    @Operation(summary = "내정보 수정", description = "내 정보 수정 API")
    @PutMapping("/profile")
    public ResponseEntity<Integer> updateMyInfo(@RequestBody Member member, HttpServletRequest request) {
        Integer memberNo = (Integer) request.getAttribute("memberNo");

        if (memberNo > 0) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        member.setMemberNo(memberNo);

        int response = myPageService.updateMyInfo(member);

        return new ResponseEntity<Integer>(response, HttpStatus.OK);
    }

    @Operation(summary = "내상점 조회", description = "내 상점 조회 API")
    @PutMapping("/profiletest")
    public ResponseEntity<Integer> test(@RequestBody Store store, HttpServletRequest request) {
        Integer response = 1;
        return new ResponseEntity<Integer>(response, HttpStatus.OK);
    }
}
