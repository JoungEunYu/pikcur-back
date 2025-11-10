package com.pikcurchu.pikcur.mapper;

import com.pikcurchu.pikcur.dto.request.ReqReviewDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {
    void insertReview(ReqReviewDto reqReviewDto);

    void insertReviewChoiceMap(Integer reviewId, List<Integer> choiceIds);
}
