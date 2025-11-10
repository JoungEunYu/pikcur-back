package com.pikcurchu.pikcur.service;

import com.pikcurchu.pikcur.dto.response.ResBrandDetailDto;
import com.pikcurchu.pikcur.dto.response.ResGoodsItemDto;
import com.pikcurchu.pikcur.mapper.BrandMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandService {
    private final BrandMapper brandMapper;

    public ResBrandDetailDto selectBrandDetail(Integer brandId, Integer memberNo) {
        return brandMapper.selectBrandDetail(brandId, memberNo);
    }

    public List<ResGoodsItemDto> selectBrandGoodsList(Integer brandId, Integer memberNo) {
        return brandMapper.selectBrandGoodsList(brandId, memberNo);
    }

    public void insertBrandLike(Integer brandId, Integer memberNo) {
        brandMapper.insertBrandLike(brandId, memberNo);
    }

    public void deleteBrandLike(Integer brandId, Integer memberNo) {
        brandMapper.deleteBrandLike(brandId, memberNo);
    }
}
