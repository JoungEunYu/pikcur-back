package com.pikcurchu.pikcur.dto.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class ResGoodsBidItemDto {
    private Integer bidId;
    private String memberId;
    private Integer bidPrice;
    private LocalDateTime createDate;
}
