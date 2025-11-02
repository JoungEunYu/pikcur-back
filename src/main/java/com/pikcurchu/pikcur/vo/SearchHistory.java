package com.pikcurchu.pikcur.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchHistory {
    private Integer searchHistoryId;
    private Integer memberNo;
    private String keyword;
    private LocalDateTime createDate;
}
