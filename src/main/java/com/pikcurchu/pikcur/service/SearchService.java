package com.pikcurchu.pikcur.service;

import com.pikcurchu.pikcur.dto.response.ResGoodsBidListDto;
import com.pikcurchu.pikcur.dto.response.ResSearchDto;
import com.pikcurchu.pikcur.mapper.SearchMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {
    private final SearchMapper searchMapper;

    public List<ResGoodsBidListDto> selectSearchGoodsList(String keyword, Integer memberNo) {
        return searchMapper.selectSearchGoodsList(keyword,memberNo);
    }

    public List<ResSearchDto> selectSearchHistory(Integer memberNo) {
        return searchMapper.selectSearchHistory(memberNo);
    }

    public List<ResSearchDto> selectSearchTop10() {
        return searchMapper.selectSearchTop10();
    }
}
