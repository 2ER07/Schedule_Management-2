package com.example.schedule_management.user.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity extends HourEntity{
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false,length = 10)
    private String userName;
    @Column(nullable = false,updatable = false,unique = true)
    private String userEmail;

    public UserEntity(String password, String userName, String userEmail) {
        this.password = password;
        this.userName = userName;
        this.userEmail = userEmail;
    }

    public void cryestal(String userName) {
        this.userName = userName;

    }
}
