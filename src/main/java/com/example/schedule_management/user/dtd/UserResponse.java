package com.example.schedule_management.user.dtd;

import lombok.Getter;

import java.time.LocalDateTime;
//서버가 클라이언트에게 응답서
@Getter
public class UserResponse {
    private final Long id;
    private final String userName;
    private final String userEmail;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public UserResponse(Long id, String userName, String userEmail, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.userName = userName;
        this.userEmail = userEmail;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
