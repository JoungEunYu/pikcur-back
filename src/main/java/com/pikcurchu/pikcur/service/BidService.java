package com.pikcurchu.pikcur.service;

import com.pikcurchu.pikcur.dto.request.ReqBidDto;
import com.pikcurchu.pikcur.dto.response.ResBidListDto;
import com.pikcurchu.pikcur.dto.response.ResGoodsBidListDto;
import com.pikcurchu.pikcur.mapper.BidMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BidService {
    private final BidMapper bidMapper;

    public List<ResGoodsBidListDto> selectBidList(Integer goodsId) {
        return bidMapper.selectBidList(goodsId);
    }

    public void insertBid(Integer goodsId, ReqBidDto reqBidDto, Integer memberNo) {
        reqBidDto.setGoodsId(goodsId);
        reqBidDto.setMemberNo(memberNo);
        bidMapper.insertBid(reqBidDto);
        bidMapper.updateBidStatus("02", reqBidDto.getGoodsId(), reqBidDto.getBidId());

    }
}
