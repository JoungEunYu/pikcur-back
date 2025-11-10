package com.pikcurchu.pikcur.dto.request;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ReqBidDto {
    private Integer bidId;
    private Integer goodsId;
    private Integer memberNo;
    private Integer bidPrice;
}
