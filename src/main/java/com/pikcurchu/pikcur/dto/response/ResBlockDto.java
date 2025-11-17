package com.pikcurchu.pikcur.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResBlockDto {
    private String profile;
    private String storeName;
    private Integer blockId;
}
