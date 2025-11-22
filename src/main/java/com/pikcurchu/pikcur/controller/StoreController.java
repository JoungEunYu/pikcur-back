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

    @Operation(summary = "로그인 회원의 상점 정보 조회", description = "회원 번호를 통해 상점 정보를 조회")
    @GetMapping("/my-store")
    public ResponseEntity<ResStoreDetailDto> selectMyStoreInfo(HttpServletRequest request) {
        Integer memberNo = (Integer) request.getAttribute("memberNo");
        ResStoreDetailDto store = storeService.selectMyStoreInfo(memberNo);
        return new ResponseEntity<>(store, HttpStatus.OK);
    }

    @Operation(summary = "리뷰 리스트 조회", description = "상점 아이디를 통해 상점 리뷰 리스트를 조회")
    @GetMapping("/reviews/{storeId}")
    public ResponseEntity<ResReviewPageDto> selectStoreReviews(@PathVariable Integer storeId, @RequestParam int currentPage) {
        ResReviewPageDto reviewPageDto = storeService.selectStoreReview(storeId, currentPage);
        return new ResponseEntity<>(reviewPageDto, HttpStatus.OK);
    }

    @Operation(summary = "상품 리스트 조회", description = "상점 아이디를 통해 상품 리스트를 조회")
    @GetMapping("/goods/{storeId}")
    public ResponseEntity<ResGoodsPageDto> selectStoreGoods(@PathVariable Integer storeId, HttpServletRequest request, @RequestParam int currentPage) {
        Integer memberNo = (Integer) request.getAttribute("memberNo");
        ResGoodsPageDto goodsList = storeService.selectStoreGoods(storeId, memberNo, currentPage);
        return new ResponseEntity<>(goodsList, HttpStatus.OK);
    }

    @Operation(summary = "판매한 거래 리스트 조회", description = "판매한 거래 리스트를 조회")
    @GetMapping("/{storeId}/transactions/sell")
    public ResponseEntity<ResSellTransactionPageDto> selectStoreSellTransaction(@PathVariable Integer storeId, @RequestParam int currentPage) {
        ResSellTransactionPageDto transactionPageDto = storeService.selectStoreSellTransaction(storeId, currentPage);
        return new ResponseEntity<>(transactionPageDto, HttpStatus.OK);
    }

    @Operation(summary = "구매한 거래 리스트 조회", description = "구매한 거래 리스트를 조회")
    @GetMapping("/{storeId}/transactions/buy")
    public ResponseEntity<ResBuyTransactionPageDto> selectStoreBuyTransaction(@PathVariable Integer storeId, @RequestParam int currentPage) {
        ResBuyTransactionPageDto transactionPageDto = storeService.selectStoreBuyTransaction(storeId, currentPage);
        return new ResponseEntity<>(transactionPageDto, HttpStatus.OK);
    }

    @Operation(summary = "입찰 내역 리스트 조회", description = "입찰한 리스트를 조회")
    @GetMapping("/{storeId}/bids")
    public ResponseEntity<ResBidsPageDto> selectStoreBids(@PathVariable Integer storeId, @RequestParam int currentPage) {
        ResBidsPageDto bidsPageDto = storeService.selectStoreBids(storeId, currentPage);
        return new ResponseEntity<>(bidsPageDto, HttpStatus.OK);
    }

    @Operation(summary = "낙찰 내역 리스트 조회", description = "낙찰한 리스트를 조회")
    @GetMapping("/{storeId}/win-bids")
    public ResponseEntity<ResBidsPageDto> selectStoreWinBids(@PathVariable Integer storeId, @RequestParam int currentPage) {
        ResBidsPageDto bidsPageDto = storeService.selectStoreWinBids(storeId, currentPage);
        return new ResponseEntity<>(bidsPageDto, HttpStatus.OK);
    }

    @Operation(summary = "찜 상품 리스트 조회", description = "찜한 상품 리스트를 조회")
    @GetMapping("/{storeId}/goods-likes")
    public ResponseEntity<ResGoodsPageDto> selectGoodsLike(@PathVariable Integer storeId, @RequestParam int currentPage) {
        ResGoodsPageDto goodsLikes = storeService.selectGoodsLike(storeId, currentPage);
        return new ResponseEntity<>(goodsLikes, HttpStatus.OK);
    }

    @Operation(summary = "찜 브랜드 리스트 조회", description = "찜한 브랜드 리스트를 조회")
    @GetMapping("/{storeId}/brand-likes")
    public ResponseEntity<ResBrandLikePageDto> selectBrandsLike(@PathVariable Integer storeId, @RequestParam int currentPage) {
        ResBrandLikePageDto brandLikePageDto = storeService.selectBrandsLike(storeId, currentPage);
        return new ResponseEntity<>(brandLikePageDto, HttpStatus.OK);
    }

    @Operation(summary = "팔로우 리스트 조회", description = "팔로우한 상점 리스트를 조회")
    @GetMapping("/{storeId}/follows")
    public ResponseEntity<ResFollowPageDto> selectFollow(@PathVariable Integer storeId, @RequestParam int currentPage) {
        ResFollowPageDto followPageDto = storeService.selectFollow(storeId, currentPage);
        return new ResponseEntity<>(followPageDto, HttpStatus.OK);
    }

    @Operation(summary = "받은 문의 리스트 조회", description = "상점 번호를 통해 받은 상품관련 문의 리스트를 조회")
    @GetMapping("/{storeId}/questions/received")
    public ResponseEntity<ResQuestionPageDto> selectReceivedQuestions(@PathVariable Integer storeId, @RequestParam int currentPage) {
        ResQuestionPageDto questionPageDto = storeService.selectReceivedQuestions(storeId, currentPage);
        return new ResponseEntity<>(questionPageDto, HttpStatus.OK);
    }

    @Operation(summary = "보낸 문의 리스트 조회", description = "상점 번호를 통해 보낸 상품관련 문의 리스트를 조회")
    @GetMapping("/{storeId}/questions/sent")
    public ResponseEntity<ResQuestionPageDto> selectSentQuestions(@PathVariable Integer storeId, @RequestParam int currentPage) {
        ResQuestionPageDto questionPageDto = storeService.selectSentQuestions(storeId, currentPage);
        return new ResponseEntity<>(questionPageDto, HttpStatus.OK);
    }

    @Operation(summary = "상점 신고", description = "상점 번호를 통해 해당 상점 신고")
    @PostMapping("/report/{storeId}")
    public ResponseEntity<Void> reportStore(@PathVariable Integer storeId, HttpServletRequest request) {
        Integer memberNo = (Integer) request.getAttribute("memberNo");
        storeService.reportStore(storeId, memberNo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "상점 차단", description = "상점 번호를 통해 해당 상점 차단")
    @PostMapping("/block/{storeId}")
    public ResponseEntity<Void> reportBlock(@PathVariable Integer storeId, HttpServletRequest request) {
        Integer memberNo = (Integer) request.getAttribute("memberNo");
        storeService.blockStore(storeId, memberNo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "팔로우", description = "팔로우")
    @PostMapping("/follow/{storeId}")
    public ResponseEntity<Integer> insertFollow(@PathVariable Integer storeId, HttpServletRequest request) {
        Integer memberNo = (Integer) request.getAttribute("memberNo");
        Integer response = storeService.insertFollow(storeId, memberNo);
        return new ResponseEntity<Integer>(response, HttpStatus.OK);
    }

    @Operation(summary = "팔로우 삭제", description = "팔로우 삭제")
    @DeleteMapping("/follow/{storeId}")
    public ResponseEntity<Integer> deleteFollow(@PathVariable Integer storeId, HttpServletRequest request) {
        Integer memberNo = (Integer) request.getAttribute("memberNo");
        Integer response = storeService.deleteFollow(storeId,memberNo);
        return new ResponseEntity<Integer>(response, HttpStatus.OK);
    }
}
