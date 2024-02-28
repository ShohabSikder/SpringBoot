package com.shohab.JwtSecurityRestApi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {
    @GetMapping("/demo")
    public ResponseEntity<String>demo(){
        return ResponseEntity.ok("Hello from secured url");
    }
    @GetMapping("/admin")
    public ResponseEntity<String>adminOnly(){
        return ResponseEntity.ok("Hello from admin only url");

    }

}