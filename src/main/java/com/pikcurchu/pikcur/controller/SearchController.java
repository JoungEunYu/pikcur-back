package com.pikcurchu.pikcur.controller;

import com.pikcurchu.pikcur.dto.response.ResGoodsBidListDto;
import com.pikcurchu.pikcur.dto.response.ResSearchDto;
import com.pikcurchu.pikcur.service.SearchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name="search api", description = "검색 관련 api")
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {
    private final SearchService searchService;

    @Operation(summary = "검색어 키워드 조회", description = "키워드를 통한 상품 리스트 조회")
    @GetMapping("/goods")
    public ResponseEntity<List<ResGoodsBidListDto>> selectSearchGoodsList(@PathVariable String keyword, HttpServletRequest request) {
        Integer memberNo = (Integer) request.getAttribute("memberNo");
        List<ResGoodsBidListDto> searchList = searchService.selectSearchGoodsList(keyword, memberNo);
        return new ResponseEntity<>(searchList, HttpStatus.OK);
    }

    @Operation(summary = "검색어 히스토리 조회", description = "회원 번호를 통한 최근 검색어 히스토리 리스트 조회")
    @GetMapping("/recent")
    public ResponseEntity<List<ResSearchDto>> selectSearchHistory(HttpServletRequest request) {
        Integer memberNo = (Integer) request.getAttribute("memberNo");
        List<ResSearchDto> historyList = searchService.selectSearchHistory(memberNo);
        return new ResponseEntity<>(historyList, HttpStatus.OK);
    }

    @Operation(summary = "인기 검색어 조회", description = "인기 검색어 top10 리스트 조회")
    @GetMapping("/popular")
    public ResponseEntity<List<ResSearchDto>> selectSearchTop10() {
        List<ResSearchDto> top10List = searchService.selectSearchTop10();
        return new ResponseEntity<>(top10List, HttpStatus.OK);
    }
}
