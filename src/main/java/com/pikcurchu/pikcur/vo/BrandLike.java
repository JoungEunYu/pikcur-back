package com.pikcurchu.pikcur.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BrandLike {

    private Integer brandLikeId;
    private Integer brandId;
    private Integer memberNo;
    private LocalDateTime createDate;
}