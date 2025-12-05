package com.korit.springboot.dto;

import com.korit.springboot.entity.CosmeticsEntity;
import lombok.Data;

@Data
public class CreatCosmeticsReqDto {
    private String cosmeticsName;
    private int price;

    public CosmeticsEntity toEntity() {
        return CosmeticsEntity.builder()
                .cosmeticsName(cosmeticsName)
                .price(price)
                .build();
    }
}
