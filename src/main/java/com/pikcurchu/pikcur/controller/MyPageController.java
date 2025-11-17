package com.pikcurchu.pikcur.controller;

import com.pikcurchu.pikcur.dto.response.MyPageInfoDto;
import com.pikcurchu.pikcur.dto.response.ResMyStoreDto;
import com.pikcurchu.pikcur.service.MyPageService;
import com.pikcurchu.pikcur.vo.Member;
import com.pikcurchu.pikcur.vo.Store;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

        MyPageInfoDto response = myPageService.selectMyInfoById(memberNo);

        return new ResponseEntity<MyPageInfoDto>(response, HttpStatus.OK);
    }

    @Operation(summary = "내정보 수정", description = "내 정보 수정 API")
    @PutMapping("/profile")
    public ResponseEntity<Integer> updateMyInfo(@RequestBody Member member, HttpServletRequest request) {
        Integer memberNo = (Integer) request.getAttribute("memberNo");

        member.setMemberNo(memberNo);

        int response = myPageService.updateMyInfo(member);

        return new ResponseEntity<Integer>(response, HttpStatus.OK);
    }

    @Operation(summary = "내상점 조회", description = "내 상점 조회 API")
    @GetMapping("/store")
    public ResponseEntity<ResMyStoreDto> selectMyStore(HttpServletRequest request) {
        Integer memberNo = (Integer) request.getAttribute("memberNo");

        ResMyStoreDto response = myPageService.selectMyStore(memberNo);

        return new ResponseEntity<ResMyStoreDto>(response, HttpStatus.OK);
    }

    @Operation(summary = "내상점 수정", description = "내 상점 수정 API")
    @PutMapping("/store")
    public ResponseEntity<Integer> updateMyStore(@RequestPart Store store,
                                                 @RequestPart(required = false) MultipartFile image) {
        Integer response = myPageService.updateMyStore(store);
        if(image != null && !image.isEmpty()) {
            myPageService.updateStoreProfile(store.getStoreId(), image);
        }

        return new ResponseEntity<Integer>(response, HttpStatus.OK);
    }

    @Operation(summary = "비밀번호 변경", description = "비밀번호 변경 API")
    @PostMapping("/password")
    public ResponseEntity<Integer> updatePassword(@RequestBody Member member, HttpServletRequest request) {
        Integer memberNo = (Integer) request.getAttribute("memberNo");
        int response = myPageService.updatePassword(memberNo, member.getPassword());
        if (response > 0) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

}
