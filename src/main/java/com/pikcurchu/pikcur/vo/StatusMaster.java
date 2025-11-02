package com.pikcurchu.pikcur.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatusMaster {

    private String statusType;
    private String statusNo;
    private String statusName;
    private String useYn;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}