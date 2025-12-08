package com.korit.springboot.service;

import com.korit.springboot.dto.SignupReqDto;
import com.korit.springboot.entity.UserEntity;
import com.korit.springboot.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserMapper userMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    @Transactional(rollbackFor = Exception.class)
    public void signup(SignupReqDto dto) {
        UserEntity userEntity = dto.toEntity(passwordEncoder);
        userMapper.insert(userEntity);
    }
}

