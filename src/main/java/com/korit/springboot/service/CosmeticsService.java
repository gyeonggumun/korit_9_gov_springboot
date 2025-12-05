package com.korit.springboot.service;

import com.korit.springboot.dto.CreatCosmeticsReqDto;
import com.korit.springboot.entity.CosmeticsEntity;
import com.korit.springboot.mapper.CosmeticsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CosmeticsService {

    private final CosmeticsMapper cosmeticsMapper;

    @Transactional(rollbackFor = Exception.class)
    public void createCosmetics(CreatCosmeticsReqDto dto) {
        CosmeticsEntity cosmeticsEntity = dto.toEntity();
        cosmeticsMapper.insert(cosmeticsEntity);

    }
}
