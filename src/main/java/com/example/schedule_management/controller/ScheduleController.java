package com.example.schedule_management.controller;

import com.example.schedule_management.dtd.ScheduleRequest;
import com.example.schedule_management.dtd.ScheduleResponse;
import com.example.schedule_management.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/scheduleManagement")
public class ScheduleController {
    public ScheduleService scheduleService;

    //생성
    public ResponseEntity<ScheduleResponse> creation(ScheduleRequest scheduleRequest){
        ScheduleResponse saved = scheduleService.creation(scheduleRequest);
       return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }


}
