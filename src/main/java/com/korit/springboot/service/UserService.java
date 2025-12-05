package com.korit.springboot.service;

import com.korit.springboot.dto.CreateUserReqDto;
import com.korit.springboot.entity.UserEntity;
import com.korit.springboot.exception.DuplicatiedException;
import com.korit.springboot.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserMapper userMapper;

    // 문제가 생겼을 때 적용(커밋)을 하지않도록 설정
    // insert, update, delect 할때는 Transactional을 걸어 주어야함
    @Transactional(rollbackFor = Exception.class)
    public int createUser(CreateUserReqDto dto) {
        UserEntity userEntity = dto.toEntity();
        userMapper.insert(userEntity);
        return userEntity.getUserId();  // insert를 다녀오고 나면 userId가 들어가 있는 상태이기 때문에 그때 리턴으로 id를 리턴해준다

    }

    public void duplicatedUsername(String username) {
        UserEntity foundUser = userMapper.findUserByUsername(username);
//        if (foundUser != null) {
//            MethodParameter methodParameter = new MethodParameter(this.getClass().getMethod("duplicatedUsername", String.class), 0);
//            BindingResult bindingResult = new BeanPropertyBindingResult(foundUser, "");
//            FieldError fieldError = new FieldError("username", "username", "이미 사용중인 사용자 이름입니다.");
//            bindingResult.addError(fieldError);
//            throw new MethodArgumentNotValidException(methodParameter, bindingResult);
//        }
        if (foundUser != null) {
            throw new DuplicatiedException("username", "이미 존재하는 사용자 이름입니다.");
        }
    }

}
