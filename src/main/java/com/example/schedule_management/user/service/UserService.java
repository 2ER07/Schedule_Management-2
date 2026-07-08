package com.example.schedule_management.user.service;

import com.example.schedule_management.schedule.dtd.ScheduleResponse;
import com.example.schedule_management.user.dtd.UserRequest;
import com.example.schedule_management.user.dtd.UserResponse;
import com.example.schedule_management.user.entity.UserEntity;
import com.example.schedule_management.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    @Transactional
    public UserResponse createUser(UserRequest userRequest) {
        UserEntity user=new UserEntity(
                userRequest.getUsername(),
                userRequest.getUserEmail()
        );
        UserEntity savedEntity= userRepository.save(user);
        UserResponse userResponse=new UserResponse(
                savedEntity.getId(),
                savedEntity.getUserName(),
                savedEntity.getUserEmail(),
                savedEntity.getCreatedAt(),
                savedEntity.getUpdatedAt()

        );
        return userResponse;


    }
}
