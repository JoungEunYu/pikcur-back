package com.pikcurchu.pikcur.service;

import com.pikcurchu.pikcur.dto.response.ResStoreDto;
import com.pikcurchu.pikcur.mapper.StoreMapper;
import org.springframework.stereotype.Service;

@Service
public class StoreService {
    private final StoreMapper storeMapper;

    public StoreService(StoreMapper storeMapper) {
        this.storeMapper = storeMapper;
    }

    public ResStoreDto selectStore(Integer storeId, Integer currentMemberNo) {
        ResStoreDto storeDto = storeMapper.findStoreDetailById(storeId, currentMemberNo);

        if (storeDto == null) {throw new IllegalArgumentException("Invalid store ID: " + storeId); }

        return storeDto;
    }
}
