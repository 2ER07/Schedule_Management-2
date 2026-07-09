package com.example.schedule_management.user.controller;

import com.example.schedule_management.user.dtd.LoginRequest;
import com.example.schedule_management.user.dtd.UserCrystalRequest;
import com.example.schedule_management.user.dtd.UserRequest;
import com.example.schedule_management.user.dtd.UserResponse;
import com.example.schedule_management.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody LoginRequest loginRequest){
        UserResponse response = userService.login(loginRequest);
       return ResponseEntity.ok(response);
    }

    //생성
    @PostMapping
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest userRequest){
        UserResponse saved = userService.createUser(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
    //전체 조회
    @GetMapping
    public ResponseEntity<List<UserResponse>> findAllUser(){
        List<UserResponse> allUser = userService.findAllUser();
        return ResponseEntity.ok(allUser);
    }

    //단일 조회
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findOneUser(@PathVariable Long id){
        UserResponse oneUser = userService.findOneUser(id);
        return ResponseEntity.ok(oneUser);
    }

    //수정
    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> crystalUser(@PathVariable Long id, @Valid @RequestBody UserCrystalRequest userCrystalRequest){
        UserResponse userCrystal = userService.crystalUser(id, userCrystalRequest);
        return ResponseEntity.ok(userCrystal);
    }

    //삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletem(@PathVariable Long id){
        userService.deletm(id);
        return ResponseEntity.noContent().build();
    }


}
