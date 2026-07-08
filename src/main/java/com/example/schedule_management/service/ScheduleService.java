package com.example.schedule_management.service;

import com.example.schedule_management.dtd.ScheduleRequest;
import com.example.schedule_management.dtd.ScheduleResponse;
import com.example.schedule_management.entity.ScheduleEntity;
import com.example.schedule_management.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    public ScheduleRepository scheduleRepository;

    public ScheduleResponse creation(ScheduleRequest scheduleRequest) {
        ScheduleEntity schedule=new ScheduleEntity(
                scheduleRequest.getName(),
                scheduleRequest.getTitle(),
                scheduleRequest.getText()
        );
        ScheduleEntity saveScheduleEntity = scheduleRepository.save(schedule);
        return new ScheduleResponse(
                saveScheduleEntity.getId(),
                saveScheduleEntity.getName(),
                saveScheduleEntity.getTitle(),
                saveScheduleEntity.getText(),
                saveScheduleEntity.getCreatedAt(),
                saveScheduleEntity.getUpdatedAt()
        );
    }
}
