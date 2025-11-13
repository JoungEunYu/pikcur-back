package com.pikcurchu.pikcur.service;

import com.pikcurchu.pikcur.dto.request.ReqGoodsDto;
import com.pikcurchu.pikcur.dto.request.ReqGoodsReportDto;
import com.pikcurchu.pikcur.dto.request.ReqStoreReportDto;
import com.pikcurchu.pikcur.dto.response.ResCategoryDto;
import com.pikcurchu.pikcur.dto.response.ResGoodsItemDto;
import com.pikcurchu.pikcur.dto.response.ResGoodsDetailDto;
import com.pikcurchu.pikcur.mapper.GoodsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GoodsService {
    private final GoodsMapper goodsMapper;
    public List<ResGoodsItemDto> selectPopularGoodsList(Integer memberNo) {
        return goodsMapper.findPopularGoodsList(memberNo);
    }
    public List<ResGoodsItemDto> selectRecentViewGoodsList(Integer memberNo) {
        return goodsMapper.findRecentViewGoodsList(memberNo);
    }
    public List<ResGoodsItemDto> selectGoodsListByEndDate(Integer memberNo) {
        return goodsMapper.findGoodsByAuctionEndAsc(memberNo);
    }
    public List<ResCategoryDto> selectCategories() {
        return goodsMapper.findCategories();
    }

    public List<ResGoodsItemDto> selectGoodsListByCategoryId(Integer categoryId, Integer memberNo) {
        return goodsMapper.findGoodsListByCategoryId(categoryId, memberNo);
    }

    public ResGoodsDetailDto selectGoodsDetailById(Integer goodsId, Integer memberNo) {
        ResGoodsDetailDto goodsDetail = goodsMapper.findGoodsDetailById(goodsId, memberNo);
    System.out.println(memberNo);
        goodsDetail.setQuestions(goodsMapper.findQuestionsById(goodsId));
        if(memberNo != null) {
            goodsMapper.insertGoodsHistory(goodsId, memberNo);
        }
        goodsMapper.updateGoodsView(goodsId);

        return goodsDetail;
    }

    public void reportGoods(Integer goodsId, Integer memberNo) {
        goodsMapper.insertGoodsReport(goodsId, memberNo);
    }

    public void insertGoodsLike(Integer goodsId, Integer memberNo) {
        goodsMapper.insertGoodsLike(goodsId, memberNo);
    }

    public void deleteGoodsLike(Integer goodsId, Integer memberNo) {
        goodsMapper.deleteGoodsLike(goodsId, memberNo);
    }

    public void insertGoods(ReqGoodsDto reqGoodsDto, Integer memberNo) {
        reqGoodsDto.setMemberNo(memberNo);
        goodsMapper.insertGoods(reqGoodsDto);
    }
}
