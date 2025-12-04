package com.korit.springboot.controller;

import com.korit.springboot.dto.RequestInsertStudyDto;
import com.korit.springboot.mapper.StudyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MybatisController {

    @Autowired    //
    private StudyMapper studyMapper;

//    @PostMapping("/mybatis/study")
//    public ResponseEntity<?> insert(String name, int age) {
//        studyMapper.insert(name, age);
//        return ResponseEntity.ok().build();
//    }

//    @PostMapping("/mybatis/study")
//    public  ResponseEntity<?> insert(@RequestBody Map<String, Object> reqMap) {
//        studyMapper.insert((String) reqMap.get("name"), (Integer) reqMap.get("age"));
//        return ResponseEntity.ok().build();
//    }

    @PostMapping("/mybatis/study")
    public  ResponseEntity<?> insert(@RequestBody RequestInsertStudyDto dto) {
        studyMapper.insert(dto.getName(), dto.getAge());
        return ResponseEntity.ok().build();
    }
}
