package com.pikcurchu.pikcur.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Block {
    private Integer blockId;
    private Integer memberNo;
    private Integer storeId;
    private LocalDateTime createDate;
    private String statusType;
    private String statusNo;
}
