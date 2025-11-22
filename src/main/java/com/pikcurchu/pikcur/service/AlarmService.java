package com.pikcurchu.pikcur.service;

import com.pikcurchu.pikcur.dto.response.ResAlarmDto;
import com.pikcurchu.pikcur.mapper.AlarmMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlarmService {
    private final AlarmMapper alarmMapper;

    public AlarmService (AlarmMapper alarmMapper) {
        this.alarmMapper = alarmMapper;
    }

    public List<ResAlarmDto> selectAlarmList(Integer memberNo) {
        return alarmMapper.selectAlarmList(memberNo);
    }

    public void insertAlarm(Integer memberNo, String alarmTitle, String alarmContent, String imagePath) {
        alarmMapper.insertAlarm(memberNo, alarmTitle, alarmContent, imagePath);
    }
}
