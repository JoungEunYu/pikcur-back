package com.pikcurchu.pikcur.controller;

import com.pikcurchu.pikcur.dto.response.ResStoreDto;
import com.pikcurchu.pikcur.service.StoreService;
import com.pikcurchu.pikcur.vo.Store;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name="store api", description = "상점 api")
@RestController
@RequestMapping("/store")
public class StoreController {
    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @Operation(summary = "상점 조회", description = "상점 아이디를 통해 상점 정보를 조회")
    @GetMapping("/{storeId}")
    public ResponseEntity<ResStoreDto> selectStore(@PathVariable Integer storeId, Integer currentMemberNo) {
        System.out.println(currentMemberNo);
        ResStoreDto store = storeService.selectStore(storeId, currentMemberNo);
        return new ResponseEntity<>(store, HttpStatus.OK);
    }
}
