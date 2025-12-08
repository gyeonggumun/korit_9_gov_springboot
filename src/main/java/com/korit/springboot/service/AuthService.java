package com.korit.springboot.service;

import com.korit.springboot.dto.SignupReqDto;
import com.korit.springboot.entity.UserEntity;
import com.korit.springboot.exception.DuplicatiedException;
import com.korit.springboot.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserMapper userMapper;

    @Transactional(rollbackFor = Exception.class)
    public int createUser(SignupReqDto dto) {
        UserEntity userEntity = dto.toEntity();
        userMapper.insert(userEntity);
        return userEntity.getUserId();
    }

    public void duplicatedUsername(String username) {
        UserEntity foundUser = userMapper.findUserByUsername(username);
        if (foundUser != null) {
            throw new DuplicatiedException("username", "이미 존재하는 사용자 이름입니다.");
        }
    }

}

