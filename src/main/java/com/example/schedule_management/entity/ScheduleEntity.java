package com.example.schedule_management.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Getter
@Table(name="schedules")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ScheduleEntity extends HourEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,updatable = true,length = 10)
    private String name;
    @Column(nullable = false,length = 50)
    private String title;
    @Column(nullable = false,length = 1000)
    private String text;


    public ScheduleEntity(String name, String title, String text) {
        this.name = name;
        this.title = title;
        this.text = text;

    }

    public void update(String title, String text) {
        this.title = title;
        this.text = text;

    }
}
