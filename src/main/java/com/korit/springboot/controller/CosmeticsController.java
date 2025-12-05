package com.korit.springboot.controller;

import com.korit.springboot.dto.CreatCosmeticsReqDto;
import com.korit.springboot.service.CosmeticsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CosmeticsController {

    private final CosmeticsService cosmeticsService;

    @PostMapping("/api/cosmtics")
    public ResponseEntity<?> creat(@Valid @RequestBody CreatCosmeticsReqDto dto){
        cosmeticsService.createCosmetics(dto);
        return ResponseEntity.ok().build();
    }

}
