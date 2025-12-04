package com.korit.springboot.controller;

import com.korit.springboot.dto.ReqJsonDto2;
import com.korit.springboot.dto.RespJsonDto;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class ResponseDataController {

    // 응답 데이터 - 문자열
    @GetMapping("/resp/data")
    public ResponseEntity<String> getString() {
        return ResponseEntity.ok("문자열 응답");
    }

    // 응답 데이터 - MAP
    @GetMapping("/resp/data2")
    public ResponseEntity<Map<String, Object>> getMap() {
        return ResponseEntity.ok(Map.of("key1", "value1", "key2", "value2"));
    }

    // 응답 데이터 - LIST
    @GetMapping("/resp/data3")
    public ResponseEntity<List<Integer>> getList() {
//        return ResponseEntity.ok(List.of("a","b","c"));
        return ResponseEntity.ok(List.of(1,2,3,4));
    }

    // 응답 데이터 - 객체
    @GetMapping("/resp/data4")
    public ResponseEntity<RespJsonDto> getObject() {
        RespJsonDto respJsonDto = new RespJsonDto();
        respJsonDto.setName("김준일");
        respJsonDto.setEmail("test12@gmail.com");
        respJsonDto.setReqJsonDto2(new ReqJsonDto2());
        return ResponseEntity.ok(respJsonDto);
    }

    @GetMapping("/resp/data5")
    public ResponseEntity<Resource> download(@RequestParam String filename) {
        Resource resource = new ClassPathResource("static/" + filename);
        System.out.println(resource);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\"" + filename + "\"")
                .body(resource);
    }


    @GetMapping("/resp/data6")
    public ResponseEntity<Resource> downloadUTF8(@RequestParam String filename) {
        Resource resource = new ClassPathResource("static/" + filename);
        System.out.println(resource);

        String contentDisposition = ContentDisposition.builder("attachment")
                .filename(filename, StandardCharsets.UTF_8)
                .build().toString();

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition)
                .body(resource);
    }



}