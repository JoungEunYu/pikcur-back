package com.pikcurchu.pikcur.controller;

import com.pikcurchu.pikcur.dto.response.ResBlockDto;
import com.pikcurchu.pikcur.service.BlockService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="block api", description = "차단상점 API")
@RestController
@RequestMapping("/mypage")
public class BlockController {
    private final BlockService blockService;

    public BlockController(BlockService blockService) {
        this.blockService = blockService;
    }

    @Operation(summary = "차단상점 조회", description = "차단 상점 조회 API")
    @GetMapping("/blocked-stores")
    public ResponseEntity<List<ResBlockDto>> selectBlockList(HttpServletRequest request) {
        Integer memberNo = (Integer) request.getAttribute("memberNo");

        List<ResBlockDto> response = blockService.selectBlockList(memberNo);

        return new ResponseEntity<List<ResBlockDto>>(response, HttpStatus.OK);
    }

    @Operation(summary = "차단상점 삭제", description = "차단 상점 삭제 API")
    @DeleteMapping("/blocked-stores/{blockId}")
    public ResponseEntity<Integer> deleteBlockStore(@PathVariable Integer blockId, HttpServletRequest request) {
        Integer memberNo = (Integer) request.getAttribute("memberNo");

        Integer response = blockService.deleteBlockStore(blockId, memberNo);

        return new ResponseEntity<Integer>(response, HttpStatus.OK);
    }
}
