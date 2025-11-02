package com.pikcurchu.pikcur.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    private Integer reviewId;
    private Integer memberNo;
    private Integer goodsId;
    private Integer starRate;
    private String content;
    private LocalDateTime createDate;
}