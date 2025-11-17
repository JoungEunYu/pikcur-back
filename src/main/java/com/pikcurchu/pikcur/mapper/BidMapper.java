package com.pikcurchu.pikcur.mapper;

import com.pikcurchu.pikcur.dto.request.ReqBidDto;
import com.pikcurchu.pikcur.dto.response.ResGoodsBidItemDto;
import com.pikcurchu.pikcur.vo.Bid;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BidMapper {
    List<ResGoodsBidItemDto> selectBidList(Map<String, Object> params);

    void insertBid(ReqBidDto reqBidDto);

    void updateBidStatus(String statusNo, Integer goodsId, Integer bidId);

    Bid findTopBidder(Integer goodsId);

    int countGoodsBidsByGoodsId(Integer goodsId);
}
