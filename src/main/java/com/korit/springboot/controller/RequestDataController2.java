package com.korit.springboot.controller;

import com.korit.springboot.dto.ReqFormDataDto4;
import com.korit.springboot.dto.ReqJsonDto2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
public class RequestDataController2 {


    // POST 요청 데이터 받는 방법 1  -  Map을 통해 JSON 데이터 받는 방법
    @PostMapping("/req/data1")
    public ResponseEntity<?> reqPost1(@RequestBody Map<String, Object> data) {
        System.out.println(data);
        System.out.println(data.get("additionalProp2"));
        return ResponseEntity.ok().build();
    }

    // POST 요청 데이터 받는 방법 2  -  DTO 통해 JSON 데이터 받는 방법
    @PostMapping("/req/data2")
    public ResponseEntity<?> reqPost2(@RequestBody ReqJsonDto2 data) {
        System.out.println(data);
        return ResponseEntity.ok().build();
    }

    // POST 요청 데이터 받는 방법 3  -  파일 데이터 받는 방법
    // 파일 전송을 위해서는 요청 Content-Type이 꼭 multipart/form-data
    @PostMapping(value = "/req/data3", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> reqPost3(@RequestPart MultipartFile file) {  // RequestParam으로 사용하기도 함
        System.out.println(file.getOriginalFilename());
        return ResponseEntity.ok().build();
    }

    // POST 요청 데이터 받는 방법 4  -  파일 데이터 받는 방법
    // 파일 전송을 위해서는 요청 Content-Type이 꼭 multipart/form-data
    @PostMapping(value = "/req/data4", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> reqPost4(ReqFormDataDto4 dto) {  // RequestParam으로 사용하기도 함
        System.out.println(dto.getFile().getOriginalFilename());
        return ResponseEntity.ok().build();
    }

    // POST 요청 데이터 받는 방법 5  -  여러파일 데이터 받는 방법
    // 파일 전송을 위해서는 요청 Content-Type이 꼭 multipart/form-data
    @PostMapping(value = "/req/data5", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> reqPost5(@RequestPart List<MultipartFile> files) {
        files.forEach(file -> System.out.println(file.getOriginalFilename()));
        return ResponseEntity.ok().build();
    }

    // PUT 요청 데이터 받는 방법 1  -  JSON 데이터만 보통 사용
    @PutMapping("/req/data")
    public ResponseEntity<?> reqPut1(@RequestBody ReqJsonDto2 dto) {  // JSON관련은 RequestBody를 붙여야함
        System.out.println(dto);
        return ResponseEntity.ok().build();
    }


}
