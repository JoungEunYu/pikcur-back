package com.pikcurchu.pikcur.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsHistory {
    private Integer goodsHistoryId;
    private Integer memberNo;
    private Integer goodsId;
    private LocalDateTime createDate;
}
