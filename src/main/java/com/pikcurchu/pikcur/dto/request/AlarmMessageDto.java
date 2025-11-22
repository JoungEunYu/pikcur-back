package com.pikcurchu.pikcur.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlarmMessageDto {
    private String alarmTitle;
    private String alarmContent;
    private String imagePath;

}
