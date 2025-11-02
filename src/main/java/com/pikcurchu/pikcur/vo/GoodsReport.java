package com.pikcurchu.pikcur.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsReport {

    private Integer goodsReportId;
    private Integer memberNo;
    private Integer goodsId;
    private LocalDateTime createDate;
    private LocalDateTime processDate;
    private String statusType;
    private String statusNo;
}