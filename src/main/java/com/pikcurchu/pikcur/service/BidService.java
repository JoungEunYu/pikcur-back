package com.pikcurchu.pikcur.service;

import com.pikcurchu.pikcur.dto.request.ReqBidDto;
import com.pikcurchu.pikcur.dto.response.ResGoodsBidItemDto;
import com.pikcurchu.pikcur.dto.response.ResGoodsBidsPageDto;
import com.pikcurchu.pikcur.mapper.BidMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BidService {
    private final BidMapper bidMapper;
    private static final int PAGE_SIZE_6 = 6;

    public ResGoodsBidsPageDto selectBidList(Integer goodsId, int currentPage) {
        int offset = (currentPage - 1) * PAGE_SIZE_6;

        // 2. 맵퍼에 파라미터 전달
        Map<String, Object> params = new HashMap<>();
        params.put("goodsId", goodsId);
        params.put("limit", PAGE_SIZE_6);
        params.put("offset", offset);

        // 3. 쿼리 2개 호출
        List<ResGoodsBidItemDto> bidList = bidMapper.selectBidList(params);
        int totalCount = bidMapper.countGoodsBidsByGoodsId(goodsId);

        // 4. 총 페이지 수 계산
        int totalPages = (int) Math.ceil((double) totalCount / PAGE_SIZE_6);

        // 5. 결과를 DTO에 담아 반환 (React가 필요한 모든 정보)
        return new ResGoodsBidsPageDto(bidList, totalPages, totalCount);
    }

    public void insertBid(Integer goodsId, ReqBidDto reqBidDto, Integer memberNo) {
        reqBidDto.setGoodsId(goodsId);
        reqBidDto.setMemberNo(memberNo);
        bidMapper.insertBid(reqBidDto);
//        bidMapper.updateBidStatus("02", reqBidDto.getGoodsId(), reqBidDto.getBidId());

    }
}
