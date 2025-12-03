package com.korit.springboot.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

// 1
// 데이터 응답할 때는 RestController를 사용하며
// ResponsBody와 Controller를 합친 것이 RestController이다
// Controller인데 ResponseBody가 없는데 String이 리턴되면 파일경로
// Controller인데 ResponseBody가 있는데 String이 리턴되면 데이터
// Model 처리한 데이터를 담아두는 역할
// View 에서는 화면을 보여주는 역할
// Controller 데이터를 처리하는 역할
// 요청과 응답을 처리하는 곳이 MVC의 역할
@RestController
public class UserController {

    private String username = "test12";
    private String password = "1234";

    // 서버사이드 랜더링을 실행하게 되면 SSR로 데이터를 처리해야함
    @GetMapping("/info")
    public ResponseEntity<String> printInfo() {
        return ResponseEntity.ok("UserController!!!");
    }

//    @GetMapping("/users")
//    public Map<String, String> getUsers(HttpServletResponse response) { // 응답처리할 때 사용되는 객체 HttpServletResponse
//         response.setStatus(400);
//         response.setContentType("application/json");
//        return Map.of("username", username, "password", password);
//    }

    @GetMapping("/users")
    public ResponseEntity<Map<String, String>> getUsers(HttpServletResponse response) {
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("username", username, "password", password));
    }

}

