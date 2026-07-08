package com.example.schedule_management.user.controller;

import com.example.schedule_management.schedule.dtd.ScheduleRequest;
import com.example.schedule_management.schedule.dtd.ScheduleResponse;
import com.example.schedule_management.user.dtd.UserRequest;
import com.example.schedule_management.user.dtd.UserResponse;
import com.example.schedule_management.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    //생성
    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest){
        UserResponse saved = userService.createUser(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }


}
