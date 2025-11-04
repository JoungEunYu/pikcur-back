package com.pikcurchu.pikcur.mapper;

import com.pikcurchu.pikcur.dto.response.ResStoreDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StoreMapper {
    ResStoreDto findStoreDetailById(Integer storeId, Integer currentMemberNo);
}
