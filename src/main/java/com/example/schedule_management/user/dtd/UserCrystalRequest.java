package com.example.schedule_management.user.dtd;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UserCrystalRequest {
    @NotBlank(message ="유저명은 필수입니다")
    @Size(max = 10, message = "이름은 10자 이하입니다")
    private String username;
}
