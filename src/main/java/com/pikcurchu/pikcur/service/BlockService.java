package com.pikcurchu.pikcur.service;

import com.pikcurchu.pikcur.dto.response.ResBlockDto;
import com.pikcurchu.pikcur.mapper.BlockMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockService {
    private final BlockMapper blockMapper;

    public BlockService(BlockMapper blockMapper) {
        this.blockMapper = blockMapper;
    }

    public List<ResBlockDto> selectBlockList(Integer memberNo) {
        return blockMapper.selectBlockList(memberNo);
    }

    public Integer deleteBlockStore(Integer blockId, Integer memberNo) {
        return blockMapper.deleteBlockStore(blockId, memberNo);
    }
}
