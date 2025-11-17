package com.pikcurchu.pikcur.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class ResFollowPageDto {
    private List<ResFollowItemDto> followList;
    private int totalPages;
    private int totalCount;
}
