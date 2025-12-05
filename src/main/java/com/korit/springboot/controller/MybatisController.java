package com.korit.springboot.controller;

import com.korit.springboot.dto.RequestInsertProductDto;
import com.korit.springboot.dto.RequestInsertStudyDto;
import com.korit.springboot.mapper.ProductMapper;
import com.korit.springboot.mapper.StudyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.ls.LSInput;

import java.util.List;
import java.util.Map;

@RestController
public class MybatisController {

    @Autowired    //
    private StudyMapper studyMapper;
    @Autowired
    private ProductMapper priceMapper;

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

    @PostMapping("/mybatis/product")
    public ResponseEntity<?> productInsert(@RequestBody RequestInsertProductDto dto) {
        priceMapper.insert(dto.getProductName(), dto.getSize(), dto.getPrice());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/mybatis/study")
    public ResponseEntity<?> selectName() {
        List<Map<String, Object>> foundName = studyMapper.findAllName();
        return ResponseEntity.ok(foundName);
    }

    @GetMapping("/mybatis/product")
    public ResponseEntity<?> selectProduct() {
        List<Map<String, Object>> foundProduct = priceMapper.findProduct();
        return ResponseEntity.ok(foundProduct);
    }
}
