package com.pikcurchu.pikcur.controller;

import com.pikcurchu.pikcur.dto.request.ReqStoreBlockDto;
import com.pikcurchu.pikcur.dto.request.ReqStoreReportDto;
import com.pikcurchu.pikcur.dto.response.*;
import com.pikcurchu.pikcur.service.StoreService;
import com.pikcurchu.pikcur.vo.GoodsLike;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
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
    public ResponseEntity<ResStoreDetailDto> selectStoreInfo(@PathVariable Integer storeId, HttpServletRequest request) {
        Integer memberNo = (Integer) request.getAttribute("memberNo");
        ResStoreDetailDto store = storeService.selectStoreInfo(storeId, memberNo);
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
    public ResponseEntity<List<ResGoodsItemDto>> selectStoreGoods(@PathVariable Integer storeId, HttpServletRequest request) {
        Integer memberNo = (Integer) request.getAttribute("memberNo");
        List<ResGoodsItemDto> goodsList = storeService.selectStoreGoods(storeId, memberNo);
        return new ResponseEntity<>(goodsList, HttpStatus.OK);
    }

    @Operation(summary = "판매한 거래 리스트 조회", description = "판매한 거래 리스트를 조회")
    @GetMapping("/{storeId}/transactions/sell")
    public ResponseEntity<List<ResTransactionItemDto>> selectStoreSellTransaction(@PathVariable Integer storeId) {
        List<ResTransactionItemDto> transactions = storeService.selectStoreSellTransaction(storeId);
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    @Operation(summary = "구매한 거래 리스트 조회", description = "구매한 거래 리스트를 조회")
    @GetMapping("/{storeId}/transactions/buy")
    public ResponseEntity<List<ResTransactionItemDto>> selectStoreBuyTransaction(@PathVariable Integer storeId) {
        List<ResTransactionItemDto> transactions = storeService.selectStoreBuyTransaction(storeId);
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    @Operation(summary = "입찰 내역 리스트 조회", description = "입찰한 리스트를 조회")
    @GetMapping("/{storeId}/bids")
    public ResponseEntity<List<ResBidListDto>> selectStoreBids(@PathVariable Integer storeId) {
        List<ResBidListDto> bids = storeService.selectStoreBids(storeId);
        return new ResponseEntity<>(bids, HttpStatus.OK);
    }

    @Operation(summary = "찜 상품 리스트 조회", description = "찜한 상품 리스트를 조회")
    @GetMapping("/{storeId}/goods-likes")
    public ResponseEntity<List<GoodsLike>> selectGoodsLike(@PathVariable Integer storeId) {
        List<GoodsLike> goodsLikes = storeService.selectGoodsLike(storeId);
        return new ResponseEntity<>(goodsLikes, HttpStatus.OK);
    }

    @Operation(summary = "찜 브랜드 리스트 조회", description = "찜한 브랜드 리스트를 조회")
    @GetMapping("/{storeId}/brand-likes")
    public ResponseEntity<List<ResBrandItemDto>> selectBransLike(@PathVariable Integer storeId) {
        List<ResBrandItemDto> brands = storeService.selectBransLike(storeId);
        return new ResponseEntity<>(brands, HttpStatus.OK);
    }

    @Operation(summary = "팔로우 리스트 조회", description = "팔로우한 상점 리스트를 조회")
    @GetMapping("/{storeId}/follows")
    public ResponseEntity<List<ResFollowItemDto>> selectFollow(@PathVariable Integer storeId) {
        List<ResFollowItemDto> follows = storeService.selectFollow(storeId);
        return new ResponseEntity<>(follows, HttpStatus.OK);
    }

    @Operation(summary = "문의 리스트 조회", description = "상점 번호를 통해 받은 상품관련 문의 리스트를 조회")
    @GetMapping("/{storeId}/questions")
    public ResponseEntity<List<ResQuestionItemDto>> selectQuestions(@PathVariable Integer storeId) {
        List<ResQuestionItemDto> questions = storeService.selectQuestions(storeId);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @Operation(summary = "상점 신고", description = "상점 번호를 통해 해당 상점 신고")
    @PostMapping("/{storeId}/report")
    public ResponseEntity<Void> reportStore(@PathVariable Integer storeId, @RequestBody ReqStoreReportDto reqStoreReportDto, HttpServletRequest request) {
        Integer memberNo = (Integer) request.getAttribute("memberNo");
        storeService.reportStore(storeId, reqStoreReportDto, memberNo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "상점 차단", description = "상점 번호를 통해 해당 상점 차단")
    @PostMapping("/{storeId}/block")
    public ResponseEntity<Void> reportStore(@PathVariable Integer storeId, @RequestBody ReqStoreBlockDto reqStoreBlockDto, HttpServletRequest request) {
        Integer memberNo = (Integer) request.getAttribute("memberNo");
        storeService.blockStore(storeId, reqStoreBlockDto, memberNo);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
