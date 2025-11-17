package com.pikcurchu.pikcur.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResAlarmDto {
    private Integer AlarmId;
    private String AlarmTitle;
    private String AlarmContent;
    private String ImagePath;
    private LocalDateTime createDate;
}
