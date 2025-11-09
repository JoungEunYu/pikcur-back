package com.pikcurchu.pikcur.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ReqStoreReportDto {
    private Integer memberNo;
    private Integer storeId;
}
