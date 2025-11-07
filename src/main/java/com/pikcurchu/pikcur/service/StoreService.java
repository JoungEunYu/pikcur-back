package com.pikcurchu.pikcur.service;

import com.pikcurchu.pikcur.dto.response.*;
import com.pikcurchu.pikcur.mapper.StoreMapper;
import com.pikcurchu.pikcur.vo.Bid;
import com.pikcurchu.pikcur.vo.Brand;
import com.pikcurchu.pikcur.vo.GoodsLike;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {
    private final StoreMapper storeMapper;

    public StoreService(StoreMapper storeMapper) {
        this.storeMapper = storeMapper;
    }

    public ResStoreDetailDto selectStoreInfo(Integer storeId, Integer currentMemberNo) {
        ResStoreDetailDto storeDto = storeMapper.findStoreInfoById(storeId, currentMemberNo);

        if (storeDto == null) {throw new IllegalArgumentException("Invalid store ID: " + storeId); }

        return storeDto;
    }

    public List<ResReviewItemDto> selectStoreReview(Integer storeId) {
        return storeMapper.findStoreReviewById(storeId);
    }

    public List<ResGoodesListDto> selectStoreGoods(Integer storeId, Integer currentMemberNo) {
        return storeMapper.findStoreGoodsById(storeId, currentMemberNo);
    }

    public List<ResTransactionItemDto> selectStoreSellTransaction(Integer memberNo) {
        return storeMapper.findStoreSellTranactionById(memberNo);
    }

    public List<ResTransactionItemDto> selectStoreBuyTransaction(Integer memberNo) {
        return storeMapper.findStoreBuyTranactionById(memberNo);
    }

    public List<ResBidListDto> selectStoreBids(Integer memberNo) {
        return storeMapper.findBidById(memberNo);
    }

    public List<GoodsLike> selectGoodsLike(Integer memberNo) {
        return storeMapper.findGoodsLikeById(memberNo);
    }

    public List<ResBrandItemDto> selectBransLike(Integer memberNo) {
        return storeMapper.findBrandLikeById(memberNo);
    }

    public List<ResFollowItemDto> selectFollow(Integer memberNo) {
        return storeMapper.findFollowById(memberNo);
    }
}
