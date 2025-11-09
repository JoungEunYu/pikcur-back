package com.pikcurchu.pikcur.service;

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
    public List<ResGoodsItemDto> selectPopularGoodsList(Integer currentMemberNo) {
        return goodsMapper.findPopularGoodsList(currentMemberNo);
    }
    public List<ResGoodsItemDto> selectRecentViewGoodsList(Integer currentMemberNo) {
        return goodsMapper.findRecentViewGoodsList(currentMemberNo);
    }
    public List<ResGoodsItemDto> selectGoodsListByEndDate(Integer currentMemberNo) {
        return goodsMapper.findGoodsByAuctionEndAsc(currentMemberNo);
    }
    public List<ResCategoryDto> selectCategories() {
        return goodsMapper.findCategories();
    }

    public List<ResGoodsItemDto> selectGoodsListByCategoryId(Integer categoryId, Integer currentMemberNo) {
        return goodsMapper.findGoodsListByCategoryId(categoryId, currentMemberNo);
    }

    public ResGoodsDetailDto selectGoodsDetailById(Integer goodsId, Integer currentMemberNo) {
        ResGoodsDetailDto goodsDetail = goodsMapper.findGoodsDetailById(goodsId, currentMemberNo);

        goodsDetail.setQuestions(goodsMapper.findQuestionsById(goodsId));
        // TODO: 조회수 + 1, 히스토리 추가 로직 예정

        return goodsDetail;
    }
}
