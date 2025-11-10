package com.pikcurchu.pikcur.mapper;

import com.pikcurchu.pikcur.dto.request.ReqStoreBlockDto;
import com.pikcurchu.pikcur.dto.request.ReqStoreReportDto;
import com.pikcurchu.pikcur.dto.response.*;
import com.pikcurchu.pikcur.vo.GoodsLike;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreMapper {
    ResStoreDetailDto findStoreInfoById(Integer storeId, Integer currentMemberNo);

    List<ResReviewItemDto> findStoreReviewById(Integer storeId);

    List<ResGoodsItemDto> findStoreGoodsById(Integer storeId, Integer currentMemberNo);

    List<ResTransactionItemDto> findStoreSellTranactionById(Integer storeId);

    List<ResTransactionItemDto> findStoreBuyTranactionById(Integer storeId);

    List<ResBidListDto> findBidById(Integer storeId);

    List<GoodsLike> findGoodsLikeById(Integer storeId);

    List<ResBrandItemDto> findBrandLikeById(Integer storeId);

    List<ResFollowItemDto> findFollowById(Integer storeId);

    List<ResQuestionItemDto> findQuestionById(Integer storeId);

    void insertStoreReport(ReqStoreReportDto reqStoreReportDto);

    void insertStoreBlock(ReqStoreBlockDto reqStoreBlockDto);
}
