package com.example.schedule_management.controller;

import com.example.schedule_management.service.ScheduleService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/scheduleManagement")
public class ScheduleController {
    public ScheduleService scheduleService;
}
