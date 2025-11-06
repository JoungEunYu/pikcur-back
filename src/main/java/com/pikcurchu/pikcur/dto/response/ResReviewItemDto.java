package com.pikcurchu.pikcur.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResReviewItemDto {
    private String memberName;
    private float rating;
    private String content;
    private LocalDateTime createDate;
    private String reviewChoices;
}
