package com.pikcurchu.pikcur.mapper;

import com.pikcurchu.pikcur.dto.response.*;
import com.pikcurchu.pikcur.vo.Bid;
import com.pikcurchu.pikcur.vo.Brand;
import com.pikcurchu.pikcur.vo.GoodsLike;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreMapper {
    ResStoreDetailDto findStoreInfoById(Integer storeId, Integer currentMemberNo);

    List<ResReviewItemDto> findStoreReviewById(Integer storeId);

    List<ResGoodesListDto> findStoreGoodsById(Integer storeId, Integer currentMemberNo);

    List<ResTransactionItemDto> findStoreSellTranactionById(Integer storeId);

    List<ResTransactionItemDto> findStoreBuyTranactionById(Integer storeId);

    List<ResBidListDto> findBidById(Integer storeId);

    List<GoodsLike> findGoodsLikeById(Integer memberNo);

    List<ResBrandItemDto> findBrandLikeById(Integer memberNo);

    List<ResFollowItemDto> findFollowById(Integer memberNo);
}
