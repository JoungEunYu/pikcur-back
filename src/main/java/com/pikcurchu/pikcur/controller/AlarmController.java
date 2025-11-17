package com.pikcurchu.pikcur.controller;

import com.pikcurchu.pikcur.dto.response.ResAlarmDto;
import com.pikcurchu.pikcur.service.AlarmService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="alarm api", description = "알람 API")
@RestController
@RequestMapping("/alarm")
public class AlarmController {
    private final AlarmService alarmService;

    public AlarmController (AlarmService alarmService) {
        this.alarmService = alarmService;
    }

    @Operation(summary = "알람 조회", description = "알람 조회 API")
    @GetMapping
    public ResponseEntity<List<ResAlarmDto>> selectAlarmList(HttpServletRequest request) {
        Integer memberNo = (Integer) request.getAttribute("memberNo");

        List<ResAlarmDto> response = alarmService.selectAlarmList(memberNo);

        return new ResponseEntity<List<ResAlarmDto>>(response, HttpStatus.OK);
    }
}
