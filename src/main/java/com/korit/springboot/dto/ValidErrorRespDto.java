package com.korit.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ValidErrorRespDto {
    // 에러를 메시지 받아서 보관해주는 dto
    private final String fieldName;
    private final String message;
}
