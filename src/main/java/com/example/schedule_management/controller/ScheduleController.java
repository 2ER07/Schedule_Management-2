package com.example.schedule_management.controller;

import com.example.schedule_management.dtd.ScheduleRequest;
import com.example.schedule_management.dtd.ScheduleResponse;
import com.example.schedule_management.dtd.UpdateRequest;
import com.example.schedule_management.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.hibernate.sql.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/scheduleManagement")
public class ScheduleController {
    public final ScheduleService scheduleService;

    //생성
    @PostMapping
    public ResponseEntity<ScheduleResponse> creationSchedule(@RequestBody ScheduleRequest scheduleRequest){
        ScheduleResponse saved = scheduleService.creation(scheduleRequest);
       return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    //전체 조회
    @GetMapping
    public ResponseEntity<List<ScheduleResponse>> findAll(){
        List<ScheduleResponse> responsesList = scheduleService.findAll();
       return ResponseEntity.ok(responsesList);
    }
    //단일 조회
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponse> findOne(@PathVariable Long id){
        ScheduleResponse response = scheduleService.findOne(id);
        return ResponseEntity.ok(response);
    }

    //수정
    @PutMapping("/{id}")
    public ResponseEntity<ScheduleResponse> updateSchedule(@PathVariable Long id, @RequestBody UpdateRequest updateRequest){
        ScheduleResponse scheduleResponse = scheduleService.updateSchedule(id, updateRequest);
        return ResponseEntity.ok(scheduleResponse);
    }
}
