package com.pikcurchu.pikcur.service;

import com.pikcurchu.pikcur.dto.request.ReqStoreBlockDto;
import com.pikcurchu.pikcur.dto.request.ReqStoreReportDto;
import com.pikcurchu.pikcur.dto.response.*;
import com.pikcurchu.pikcur.mapper.StoreMapper;
import com.pikcurchu.pikcur.vo.GoodsLike;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {
    private final StoreMapper storeMapper;

    public StoreService(StoreMapper storeMapper) {
        this.storeMapper = storeMapper;
    }

    public ResStoreDetailDto selectStoreInfo(Integer storeId, Integer memberNo) {
        ResStoreDetailDto storeDto = storeMapper.findStoreInfoById(storeId, memberNo);

        if (storeDto == null) {throw new IllegalArgumentException("Invalid store ID: " + storeId); }

        return storeDto;
    }

    public List<ResReviewItemDto> selectStoreReview(Integer storeId) {
        return storeMapper.findStoreReviewById(storeId);
    }

    public List<ResGoodsItemDto> selectStoreGoods(Integer storeId, Integer memberNo) {
        return storeMapper.findStoreGoodsById(storeId, memberNo);
    }

    public List<ResTransactionItemDto> selectStoreSellTransaction(Integer storeId) {
        return storeMapper.findStoreSellTranactionById(storeId);
    }

    public List<ResTransactionItemDto> selectStoreBuyTransaction(Integer storeId) {
        return storeMapper.findStoreBuyTranactionById(storeId);
    }

    public List<ResBidListDto> selectStoreBids(Integer storeId) {
        return storeMapper.findBidById(storeId);
    }

    public List<GoodsLike> selectGoodsLike(Integer storeId) {
        return storeMapper.findGoodsLikeById(storeId);
    }

    public List<ResBrandItemDto> selectBransLike(Integer storeId) {
        return storeMapper.findBrandLikeById(storeId);
    }

    public List<ResFollowItemDto> selectFollow(Integer storeId) {
        return storeMapper.findFollowById(storeId);
    }

    public List<ResQuestionItemDto> selectQuestions(Integer storeId) {
        return storeMapper.findQuestionById(storeId);
    }

    public void reportStore(Integer storeId, ReqStoreReportDto reqStoreReportDto, Integer memberNo) {
        reqStoreReportDto.setStoreId(storeId);
        reqStoreReportDto.setMemberNo(memberNo);
        storeMapper.insertStoreReport(reqStoreReportDto);
    }

    public void blockStore(Integer storeId, ReqStoreBlockDto reqStoreBlockDto, Integer memberNo) {
        reqStoreBlockDto.setStoreId(storeId);
        reqStoreBlockDto.setMemberNo(memberNo);
        storeMapper.insertStoreBlock(reqStoreBlockDto);
    }

    public Integer insertFollow(Integer storeId, Integer memberNo) {
        return storeMapper.insertFollow(storeId, memberNo);
    }

    public Integer deleteFollow(Integer followId) {
        return storeMapper.deleteFollow(followId);
    }
}
