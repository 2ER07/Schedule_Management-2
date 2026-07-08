package com.example.schedule_management.repository;

import com.example.schedule_management.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<ScheduleEntity,Long> {

}
