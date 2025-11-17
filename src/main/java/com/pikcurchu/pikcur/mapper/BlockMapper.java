package com.pikcurchu.pikcur.mapper;

import com.pikcurchu.pikcur.dto.response.ResBlockDto;

import java.util.List;

public interface BlockMapper {
    List<ResBlockDto> selectBlockList(Integer memberNo);

    Integer deleteBlockStore(Integer blockId, Integer memberNo);
}
