package com.pikcurchu.pikcur.controller;

import com.pikcurchu.pikcur.dto.response.*;
import com.pikcurchu.pikcur.service.StoreService;
import com.pikcurchu.pikcur.vo.GoodsLike;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="store api", description = "상점 관련 api")
@RestController
@RequestMapping("/store")
public class StoreController {
    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @Operation(summary = "상점 정보 조회", description = "상점 아이디를 통해 상점 정보를 조회")
    @GetMapping("/{storeId}")
    public ResponseEntity<ResStoreDetailDto> selectStoreInfo(@PathVariable Integer storeId, Integer currentMemberNo) {
        ResStoreDetailDto store = storeService.selectStoreInfo(storeId, currentMemberNo);
        return new ResponseEntity<>(store, HttpStatus.OK);
    }

    @Operation(summary = "리뷰 리스트 조회", description = "상점 아이디를 통해 상점 리뷰 리스트를 조회")
    @GetMapping("/{storeId}/reviews")
    public ResponseEntity<List<ResReviewItemDto>> selectStoreReviews(@PathVariable Integer storeId) {
        List<ResReviewItemDto> reviews = storeService.selectStoreReview(storeId);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @Operation(summary = "상품 리스트 조회", description = "상점 아이디를 통해 상품 리스트를 조회")
    @GetMapping("/{storeId}/goods")
    public ResponseEntity<List<ResGoodesListDto>> selectStoreGoods(@PathVariable Integer storeId, Integer currentMemberNo) {
        List<ResGoodesListDto> goodsList = storeService.selectStoreGoods(storeId, currentMemberNo);
        return new ResponseEntity<>(goodsList, HttpStatus.OK);
    }

    @Operation(summary = "판매한 거래 리스트 조회", description = "회원번호를 통해 판매한 거래 리스트를 조회")
    @GetMapping("/{memberNo}/transactions/sell")
    public ResponseEntity<List<ResTransactionItemDto>> selectStoreSellTransaction(@PathVariable Integer memberNo) {
        List<ResTransactionItemDto> transactions = storeService.selectStoreSellTransaction(memberNo);
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    @Operation(summary = "구매한 거래 리스트 조회", description = "회원번호를 통해 구매한 거래 리스트를 조회")
    @GetMapping("/{memberNo}/transactions/buy")
    public ResponseEntity<List<ResTransactionItemDto>> selectStoreBuyTransaction(@PathVariable Integer memberNo) {
        List<ResTransactionItemDto> transactions = storeService.selectStoreBuyTransaction(memberNo);
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    @Operation(summary = "입찰 내역 리스트 조회", description = "회원번호를 통해 입찰한 리스트를 조회")
    @GetMapping("/{memberNo}/bid")
    public ResponseEntity<List<ResBidListDto>> selectStoreBids(@PathVariable Integer memberNo) {
        List<ResBidListDto> bids = storeService.selectStoreBids(memberNo);
        return new ResponseEntity<>(bids, HttpStatus.OK);
    }

    @Operation(summary = "찜 상품 리스트 조회", description = "회원 번호를 통해 찜한 상품 리스트를 조회")
    @GetMapping("/{memberNo}/goods-like")
    public ResponseEntity<List<GoodsLike>> selectGoodsLike(@PathVariable Integer memberNo) {
        List<GoodsLike> goodsLikes = storeService.selectGoodsLike(memberNo);
        return new ResponseEntity<>(goodsLikes, HttpStatus.OK);
    }

    @Operation(summary = "찜 브랜드 리스트 조회", description = "회원 번호를 통해 찜한 브랜드 리스트를 조회")
    @GetMapping("/{memberNo}/brand-like")
    public ResponseEntity<List<ResBrandItemDto>> selectBransLike(@PathVariable Integer memberNo) {
        List<ResBrandItemDto> brands = storeService.selectBransLike(memberNo);
        return new ResponseEntity<>(brands, HttpStatus.OK);
    }

    @Operation(summary = "팔로우 리스트 조회", description = "회원 번호를 통해 팔로우한 상점 리스트를 조회")
    @GetMapping("/{memberNo}/follow")
    public ResponseEntity<List<ResFollowItemDto>> selectFollow(@PathVariable Integer memberNo) {
        List<ResFollowItemDto> follows = storeService.selectFollow(memberNo);
        return new ResponseEntity<>(follows, HttpStatus.OK);
    }
}
