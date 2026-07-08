package com.example.schedule_management.schedule.service;

import com.example.schedule_management.schedule.dtd.ScheduleRequest;
import com.example.schedule_management.schedule.dtd.ScheduleResponse;
import com.example.schedule_management.schedule.dtd.UpdateRequest;
import com.example.schedule_management.schedule.entity.ScheduleEntity;
import com.example.schedule_management.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    @Transactional
    public ScheduleResponse create(ScheduleRequest scheduleRequest) {
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
                ()-> new IllegalArgumentException("없는 ID입니다")
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
    @Transactional
    public ScheduleResponse updateSchedule(Long id, UpdateRequest updateRequest) {
        ScheduleEntity scheduleEntity=scheduleRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("없는 ID입니다")
        );
        scheduleEntity.update(
                updateRequest.getTitle(),
                updateRequest.getText()
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
    @Transactional
    public void delete(Long id) {
        boolean existence = scheduleRepository.existsById(id);

        if (!existence){
            throw new IllegalArgumentException("없는 id 입니다");
        }

        scheduleRepository.deleteById(id);
    }
}
