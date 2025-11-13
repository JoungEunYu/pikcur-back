package com.pikcurchu.pikcur.service;

import com.pikcurchu.pikcur.dto.request.ReqReviewDto;
import com.pikcurchu.pikcur.mapper.ReviewMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewMapper reviewMapper;

    public void insertReview(Integer storeId, ReqReviewDto reqReviewDto, Integer memberNo) {
        reqReviewDto.setStoreId(storeId);
        reqReviewDto.setMemberNo(memberNo);
        reviewMapper.insertReview(reqReviewDto);
        Integer reviewId = reqReviewDto.getReviewId();

        if (reqReviewDto.getChoiceIds() != null && !reqReviewDto.getChoiceIds().isEmpty()) {
            reviewMapper.insertReviewChoiceMap(reviewId, reqReviewDto.getChoiceIds());
        }
    }
}
