package com.example.schedule_management.service;

import com.example.schedule_management.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    public ScheduleRepository scheduleRepository;
}
