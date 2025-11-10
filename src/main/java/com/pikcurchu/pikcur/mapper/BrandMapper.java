package com.pikcurchu.pikcur.mapper;

import com.pikcurchu.pikcur.dto.response.ResBrandDetailDto;
import com.pikcurchu.pikcur.dto.response.ResGoodsItemDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BrandMapper {
    ResBrandDetailDto selectBrandDetail(Integer brandId, Integer memberNo);

    List<ResGoodsItemDto> selectBrandGoodsList(Integer brandId, Integer memberNo);

    void insertBrandLike(Integer brandId, Integer memberNo);

    void deleteBrandLike(Integer brandId, Integer memberNo);
}
