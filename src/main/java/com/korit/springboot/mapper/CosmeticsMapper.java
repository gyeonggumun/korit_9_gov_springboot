package com.korit.springboot.mapper;

import com.korit.springboot.entity.CosmeticsEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CosmeticsMapper {
    int insert(CosmeticsEntity cosmeticsEntity);
}
