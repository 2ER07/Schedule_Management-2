package com.example.schedule_management.schedule.dtd;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponse {
    private final Long id;
    private final String name;
    private final String title;
    private final String text;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public ScheduleResponse(Long id, String name, String title, String text, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.text = text;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
