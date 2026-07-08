package com.example.schedule_management.schedule.repository;

import com.example.schedule_management.schedule.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<ScheduleEntity,Long> {

}
