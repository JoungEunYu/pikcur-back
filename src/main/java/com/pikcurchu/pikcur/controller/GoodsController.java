package com.pikcurchu.pikcur.controller;

import com.pikcurchu.pikcur.dto.response.ResCategoryDto;
import com.pikcurchu.pikcur.dto.response.ResGoodsItemDto;
import com.pikcurchu.pikcur.dto.response.ResGoodsDetailDto;
import com.pikcurchu.pikcur.service.GoodsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="goods api", description = "상품 관련 api")
@RestController
@RequestMapping("/goods")
@RequiredArgsConstructor
public class GoodsController {
    private final GoodsService goodsService;

    @Operation(summary = "인기 상품 조회", description = "좋아요 수 기준 인기 상품 리스트 조회")
    @GetMapping("/popular")
    public ResponseEntity<List<ResGoodsItemDto>> selectPopularGoodsList(@RequestParam Integer currentMemberNo) {
        List<ResGoodsItemDto> goodsList = goodsService.selectPopularGoodsList(currentMemberNo);
        return new ResponseEntity<>(goodsList, HttpStatus.OK);
    }

    @Operation(summary = "최근 본 상품 조회", description = "최근 본 상품 리스트 조회")
    @GetMapping("/recent")
    public ResponseEntity<List<ResGoodsItemDto>> selectRecentViewGoodsList(@RequestParam Integer currentMemberNo) {
        List<ResGoodsItemDto> goodsList = goodsService.selectRecentViewGoodsList(currentMemberNo);
        return new ResponseEntity<>(goodsList, HttpStatus.OK);
    }

    @Operation(summary = "마감 임박 상품 조회", description = "마감 임박 상품 리스트 조회")
    @GetMapping("/closing-soon")
    public ResponseEntity<List<ResGoodsItemDto>> selectGoodsListByEndDate(@RequestParam Integer currentMemberNo) {
        List<ResGoodsItemDto> goodsList = goodsService.selectGoodsListByEndDate(currentMemberNo);
        return new ResponseEntity<>(goodsList, HttpStatus.OK);
    }

    @Operation(summary = "카테고리 리스트 조회", description = "카테고리 리스트 조회")
    @GetMapping("/categories")
    public ResponseEntity<List<ResCategoryDto>> selectCategories() {
        List<ResCategoryDto> categories = goodsService.selectCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @Operation(summary = "카테고리 별 상품 조회", description = "카테고리 아이디를 통한 상품 리스트 조회")
    @GetMapping("/categories/{categoryId}")
    public ResponseEntity<List<ResGoodsItemDto>> selectGoodsListByCategoryId(@PathVariable Integer categoryId, @RequestParam Integer currentMemberNo) {
        List<ResGoodsItemDto> goodsList = goodsService.selectGoodsListByCategoryId(categoryId, currentMemberNo);
        return new ResponseEntity<>(goodsList, HttpStatus.OK);
    }

    @Operation(summary = "상품 상세 조회", description = "상품 아이디를 통한 상품 상세 조회")
    @GetMapping("/{goodsId}")
    public ResponseEntity<ResGoodsDetailDto> selectGoodsDetailById(@PathVariable Integer goodsId, @RequestParam Integer currentMemberNo) {
        ResGoodsDetailDto goodsDetail = goodsService.selectGoodsDetailById(goodsId, currentMemberNo);
        return new ResponseEntity<>(goodsDetail, HttpStatus.OK);
    }
}
