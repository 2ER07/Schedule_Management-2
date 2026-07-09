package com.example.schedule_management.user.dtd;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
//클라이언트 요쳥서
@Getter
public class UserRequest {

    @NotBlank(message ="유저명은 필수입니다")
    @Size(max = 10, message = "이름은 10자 이하입니다")
    private String username;
    @Email(message ="올바른 이메일 형식이 아닙니다")
    @NotBlank(message = "이메일은 필수입니다")
    private String userEmail;
    @NotBlank(message = "비밀번호는 필수 입니다")
    @Size(min = 8,message = "비밀번호는 8자 이상이어야 합니다")
    private String password;
}
