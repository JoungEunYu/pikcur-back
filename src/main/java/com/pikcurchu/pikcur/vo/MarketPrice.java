package com.pikcurchu.pikcur.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarketPrice {
    private Integer priceId;
    private Integer productId;
    private Integer price;
    private LocalDateTime createDate;
}
