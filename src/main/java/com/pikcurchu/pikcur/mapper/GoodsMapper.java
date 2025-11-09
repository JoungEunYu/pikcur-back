package com.pikcurchu.pikcur.mapper;

import com.pikcurchu.pikcur.dto.response.QuestionInfo;
import com.pikcurchu.pikcur.dto.response.ResCategoryDto;
import com.pikcurchu.pikcur.dto.response.ResGoodsItemDto;
import com.pikcurchu.pikcur.dto.response.ResGoodsDetailDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsMapper {
    List<ResGoodsItemDto> findPopularGoodsList(Integer currentMemberNo);

    List<ResGoodsItemDto> findRecentViewGoodsList(Integer currentMemberNo);

    List<ResGoodsItemDto> findGoodsByAuctionEndAsc(Integer currentMemberNo);

    List<ResCategoryDto> findCategories();

    List<ResGoodsItemDto> findGoodsListByCategoryId(Integer categoryId, Integer currentMemberNo);

    ResGoodsDetailDto findGoodsDetailById(Integer goodsId, Integer currentMemberNo);

    List<QuestionInfo> findQuestionsById(Integer goodsId);
}
