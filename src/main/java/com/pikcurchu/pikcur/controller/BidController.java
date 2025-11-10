package com.pikcurchu.pikcur.controller;

import com.pikcurchu.pikcur.dto.request.ReqBidDto;
import com.pikcurchu.pikcur.dto.request.ReqQuestionDto;
import com.pikcurchu.pikcur.dto.response.ResBidListDto;
import com.pikcurchu.pikcur.dto.response.ResGoodsBidListDto;
import com.pikcurchu.pikcur.service.BidService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name="bid api", description = "입찰 관련 api")
@RequestMapping("/goods")
@RequiredArgsConstructor
public class BidController {
    private final BidService bidService;

    @Operation(summary = "입찰 리스트 조회", description = "상품 아이디를 통한 입찰 리스트 조회")
    @GetMapping("/{goodsId}/bids")
    public ResponseEntity<List<ResGoodsBidListDto>> selectBidList(@PathVariable Integer goodsId) {
        List<ResGoodsBidListDto> bidList = bidService.selectBidList(goodsId);
        return new ResponseEntity<>(bidList, HttpStatus.OK);
    }

    @Operation(summary = "입찰 등록", description = "상품에 대한 입찰 등록")
    @PostMapping("/{goodsId}/bids")
    public ResponseEntity<Void> insertBid(@PathVariable Integer goodsId, @RequestBody ReqBidDto reqBidDto) {
        bidService.insertBid(goodsId, reqBidDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
