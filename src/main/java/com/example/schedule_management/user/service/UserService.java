package com.example.schedule_management.user.service;

import com.example.schedule_management.schedule.dtd.ScheduleResponse;
import com.example.schedule_management.user.dtd.UserCrystalRequest;
import com.example.schedule_management.user.dtd.UserRequest;
import com.example.schedule_management.user.dtd.UserResponse;
import com.example.schedule_management.user.entity.UserEntity;
import com.example.schedule_management.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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
    @Transactional(readOnly = true)
    public List<UserResponse> findAllUser() {
        List<UserResponse> findAllUserList = new ArrayList<>();
        List<UserEntity> userEntityList=userRepository.findAll();
        for (UserEntity userEntity : userEntityList){
            UserResponse userResponse = new UserResponse(
                    userEntity.getId(),
                    userEntity.getUserName(),
                    userEntity.getUserEmail(),
                    userEntity.getCreatedAt(),
                    userEntity.getUpdatedAt()
            );
            findAllUserList.add(userResponse);
        }
        return findAllUserList;
    }
    @Transactional(readOnly = true)
    public UserResponse findOneUser(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("없는 ID입니다")
        );
        UserResponse userResponse=new UserResponse(
                userEntity.getId(),
                userEntity.getUserName(),
                userEntity.getUserEmail(),
                userEntity.getCreatedAt(),
                userEntity.getUpdatedAt()
        );
        return userResponse;
    }
    @Transactional
    public UserResponse crystalUser(Long id, UserCrystalRequest userCrystalRequest) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("없는 ID입니다")
        );
        userEntity.cryestal(
                userCrystalRequest.getUsername()
        );

       return new UserResponse(
                userEntity.getId(),
                userEntity.getUserName(),
                userEntity.getUserEmail(),
                userEntity.getCreatedAt(),
                userEntity.getUpdatedAt()
       );
    }

    public void deletm(Long id) {
        boolean existence = userRepository.existsById(id);
        if (!existence){
            throw new IllegalArgumentException("없는 id이다");
        }
        userRepository.deleteById(id);
    }
}
