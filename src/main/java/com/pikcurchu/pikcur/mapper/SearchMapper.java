package com.pikcurchu.pikcur.mapper;

import com.pikcurchu.pikcur.dto.response.ResGoodsBidListDto;
import com.pikcurchu.pikcur.dto.response.ResSearchDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SearchMapper {
    List<ResGoodsBidListDto> selectSearchGoodsList(String keyword, Integer memberNo);

    List<ResSearchDto> selectSearchHistory(Integer memberNo);

    List<ResSearchDto> selectSearchTop10();
}
