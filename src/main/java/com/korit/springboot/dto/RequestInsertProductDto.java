package com.korit.springboot.dto;

import lombok.Data;

@Data
public class RequestInsertProductDto {
    private String productName;
    private String size;
    private int price;
}
