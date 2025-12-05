package com.korit.springboot.mapper;

import com.korit.springboot.entity.CosmeticsEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CosmeticsMapper {
    int insert(CosmeticsEntity cosmeticsEntity);
    CosmeticsEntity findCosmeticsByCosmeticsName(@Param("cosmeticsName") String cosmeticsName);
}
