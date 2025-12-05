package com.korit.springboot.dto;

import com.korit.springboot.entity.UserEntity;
import lombok.Data;

@Data
public class CreateUserReqDto {
    private String username;
    private String password;
    private String name;
    private String email;

    public UserEntity toEntity() {
//        UserEntity userEntity = new UserEntity();
//        userEntity.setUsername(username);
//        userEntity.setPassword(password);
//        userEntity.setName(name);
//        userEntity.setEmail(email);
        return UserEntity.builder()
                .username(username)
                .password(password)
                .name(name)
                .email(email)
                .build();
    }
}
