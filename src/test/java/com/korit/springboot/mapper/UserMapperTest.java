package com.korit.springboot.mapper;

import com.korit.springboot.entity.UserEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional  // Transactional을 걸어두면 롤백되어 데이터가 들어가지 않음
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void insertTest() {
        UserEntity userEntity = UserEntity.builder()
                .username("test")
                .password("1234")
                .name("문경구")
                .email("test@gmail.com")
                .build();
        int successCount = userMapper.insert(userEntity);
        System.out.println(successCount);
        Assertions.assertThat(successCount).isEqualTo(1);
    }

    @Test
    void findUserByUsernameTest() {
        UserEntity foundUser = userMapper.findUserByUsername("test123");
        System.out.println(foundUser);
    }
}
