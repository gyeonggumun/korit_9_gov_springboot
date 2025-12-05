package com.korit.springboot.exception;

import com.korit.springboot.dto.ValidErrorRespDto;
import lombok.Getter;

import java.util.List;

public class DuplicatiedException extends RuntimeException{
    @Getter
    private ValidErrorRespDto validErrorRespDto;

    public DuplicatiedException(String fieldName, String message) {
        super(message);
        this.validErrorRespDto = new ValidErrorRespDto(fieldName, message);
    }

}
