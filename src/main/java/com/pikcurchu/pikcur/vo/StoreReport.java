package com.pikcurchu.pikcur.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreReport {

    private Integer storeReportId;
    private Integer storeId;
    private Integer memberNo;
    private LocalDateTime createDate;
    private LocalDateTime processDate;
    private String statusType;
    private String statusNo;
}