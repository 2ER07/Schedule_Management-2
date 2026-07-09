package com.example.schedule_management.schedule.entity;

import com.example.schedule_management.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name="schedule")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ScheduleEntity extends HourEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
    @Column(nullable = false,length = 50)
    private String title;
    @Column(nullable = false,length = 1000)
    private String text;


    public ScheduleEntity(UserEntity user, String title, String text) {
        this.user = user;
        this.title = title;
        this.text = text;
    }

    public void update(String title, String text) {
        this.title = title;
        this.text = text;

    }
}
