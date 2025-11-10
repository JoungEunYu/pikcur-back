package com.pikcurchu.pikcur.mapper;

import com.pikcurchu.pikcur.dto.request.ReqBidDto;
import com.pikcurchu.pikcur.dto.response.ResBidListDto;
import com.pikcurchu.pikcur.dto.response.ResGoodsBidListDto;
import com.pikcurchu.pikcur.vo.Bid;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BidMapper {
    List<ResGoodsBidListDto> selectBidList(Integer goodsId);

    void insertBid(ReqBidDto reqBidDto);

    void updateBidStatus(String statusNo, Integer goodsId, Integer bidId);

    Bid findTopBidder(Integer goodsId);
}
