package com.korit.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudyMapper {
    int insert(@Param("name") String name,@Param("age") int age);
    List<String> findAllName();   // 객체일 때를 제외하고는 resultType을 제외하고 사용가능
}
