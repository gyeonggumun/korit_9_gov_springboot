package com.korit.springboot.service;

import com.korit.springboot.dto.CreateUserReqDto;
import com.korit.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    // 문제가 생겼을 때 적용(커밋)을 하지않도록 설정
    // insert, update, delect 할때는 Transactional을 걸어 주어야함
    @Transactional(rollbackFor = Exception.class)
    public void createUser(CreateUserReqDto dto) {
        userMapper.insert(dto.toEntity());
    }

}
