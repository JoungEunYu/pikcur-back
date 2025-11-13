package com.pikcurchu.pikcur.mapper;

import com.pikcurchu.pikcur.dto.request.ReqGoodsDto;
import com.pikcurchu.pikcur.dto.request.ReqGoodsReportDto;
import com.pikcurchu.pikcur.dto.response.QuestionInfo;
import com.pikcurchu.pikcur.dto.response.ResCategoryDto;
import com.pikcurchu.pikcur.dto.response.ResGoodsItemDto;
import com.pikcurchu.pikcur.dto.response.ResGoodsDetailDto;
import com.pikcurchu.pikcur.vo.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsMapper {
    List<ResGoodsItemDto> findPopularGoodsList(Integer memberNo);

    List<ResGoodsItemDto> findRecentViewGoodsList(Integer memberNo);

    List<ResGoodsItemDto> findGoodsByAuctionEndAsc(Integer memberNo);

    List<ResCategoryDto> findCategories();

    List<ResGoodsItemDto> findGoodsListByCategoryId(Integer categoryId, Integer memberNo);

    ResGoodsDetailDto findGoodsDetailById(Integer goodsId, Integer memberNo);

    List<QuestionInfo> findQuestionsById(Integer goodsId);

    void insertGoodsReport(Integer goodsId, Integer memberNo);

    void insertGoodsLike(Integer goodsId, Integer memberNo);

    void deleteGoodsLike(Integer goodsId, Integer memberNo);

    void insertGoodsHistory(Integer goodsId, Integer memberNo);

    void updateGoodsView(Integer goodsId);

    void insertGoods(ReqGoodsDto reqGoodsDto);

    List<Goods> findExpiredGoods();

    void updateGoodsStatus(String statusNo, Integer goodsId);

    Integer findMemberNoOfStore(Integer storeId);
}
