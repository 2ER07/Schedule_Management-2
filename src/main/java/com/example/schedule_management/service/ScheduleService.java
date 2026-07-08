package com.example.schedule_management.service;

import com.example.schedule_management.dtd.ScheduleRequest;
import com.example.schedule_management.dtd.ScheduleResponse;
import com.example.schedule_management.entity.ScheduleEntity;
import com.example.schedule_management.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.apache.bcel.generic.RET;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    public final ScheduleRepository scheduleRepository;

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
    @Transactional(readOnly = true)
    public List<ScheduleResponse> findAll() {
        List<ScheduleResponse> scheduleResponsesList=new ArrayList<>();
        List<ScheduleEntity> scheduleEntitiesList=scheduleRepository.findAll();
        for (ScheduleEntity scheduleEntity : scheduleEntitiesList){
            ScheduleResponse scheduleRequests= new ScheduleResponse(
                    scheduleEntity.getId(),
                    scheduleEntity.getName(),
                    scheduleEntity.getTitle(),
                    scheduleEntity.getText(),
                    scheduleEntity.getCreatedAt(),
                    scheduleEntity.getUpdatedAt()
            );
            scheduleResponsesList.add(scheduleRequests);

        }
        return scheduleResponsesList;
    }
    @Transactional
    public ScheduleResponse findOne(Long id) {
        ScheduleEntity scheduleEntity=scheduleRepository.findById(id).orElseThrow(
                ()-> new IllegalStateException("없는 ID입니다")
        );

        return new ScheduleResponse(
                scheduleEntity.getId(),
                scheduleEntity.getName(),
                scheduleEntity.getTitle(),
                scheduleEntity.getText(),
                scheduleEntity.getCreatedAt(),
                scheduleEntity.getUpdatedAt()
        );
    }
}
