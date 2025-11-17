package com.pikcurchu.pikcur.mapper;

import com.pikcurchu.pikcur.dto.response.ResAlarmDto;

import java.util.List;

public interface AlarmMapper {

    List<ResAlarmDto> selectAlarmList(Integer MemberNo);
}
