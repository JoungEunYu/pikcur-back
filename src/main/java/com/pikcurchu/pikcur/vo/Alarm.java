package com.pikcurchu.pikcur.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Alarm {
    private Integer alarmId;
    private String alarmCode;
    private String alarmTitle;
    private String alarmContent;
    private String imagePath;
    private LocalDateTime createDate;
    private LocalDateTime sendDate;
    private String statusType;
    private String statusNo;}
