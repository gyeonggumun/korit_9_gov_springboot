package com.korit.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductMapper {
    int insert(@Param("productName") String productName, @Param("size") String size, @Param("price") int price);
    List<Map<String, Object>> findProduct ();
}
