package com.example.schedule_management.schedule.controller;

import com.example.schedule_management.schedule.dtd.ScheduleRequest;
import com.example.schedule_management.schedule.dtd.ScheduleResponse;
import com.example.schedule_management.schedule.dtd.UpdateRequest;
import com.example.schedule_management.schedule.service.ScheduleService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/scheduleManagement")
public class ScheduleController {
    private final ScheduleService scheduleService;

    //생성
    @PostMapping
    public ResponseEntity<ScheduleResponse> creationSchedule(@RequestBody ScheduleRequest scheduleRequest, HttpSession session){
        Long userID=(Long) session.getAttribute("loginUserId");
        if (userID ==null){
            throw new IllegalArgumentException("로그인이 필요합니다");
        }
        ScheduleResponse saved = scheduleService.create(scheduleRequest,userID);
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

    //삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        scheduleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
