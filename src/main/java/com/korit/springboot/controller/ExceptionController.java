package com.korit.springboot.controller;

import com.korit.springboot.dto.ValidErrorRespDto;
import com.korit.springboot.exception.DuplicatiedException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.management.BadAttributeValueExpException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<String> duplicatedException(SQLIntegrityConstraintViolationException e) {
        e.printStackTrace();
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ValidErrorRespDto>> validException(MethodArgumentNotValidException e) {
//        Map<String, String> errorMap = new LinkedHashMap<>();
//        e.getFieldErrors().forEach(error -> {
//            errorMap.put(error.getField(), error.getDefaultMessage());
//        });

        List<ValidErrorRespDto> errors = e.getFieldErrors()
                .stream()
                .map(error -> new ValidErrorRespDto(error.getField(), error.getDefaultMessage()))
                .toList();

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(DuplicatiedException.class)
    public ResponseEntity<ValidErrorRespDto> duplicatedException(DuplicatiedException e) {
        return ResponseEntity.badRequest().body(e.getValidErrorRespDto());
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<Map<String, String>> authenticationException(UsernameNotFoundException e) {
        return ResponseEntity.badRequest().body(Map.of("message", e.getMessage()));
    }

    @ExceptionHandler(BadAttributeValueExpException.class)
    public ResponseEntity<Map<String, String>> authenticationException(BadAttributeValueExpException e) {
        return ResponseEntity.badRequest().body(Map.of("message", e.getMessage()));
    }
}
