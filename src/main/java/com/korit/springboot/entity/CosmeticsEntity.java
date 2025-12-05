package com.korit.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CosmeticsEntity {
    private int cosmeticsId;
    private String cosmeticsName;
    private int price;
}
