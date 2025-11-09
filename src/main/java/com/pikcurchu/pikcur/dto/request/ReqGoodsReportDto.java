package com.pikcurchu.pikcur.dto.request;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ReqGoodsReportDto {
    private Integer goodsId;
    private Integer memberNo;
}
