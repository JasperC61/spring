package com.example.demo;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @RequestMapping("/tt1")
    public ResponseEntity<String> tt1(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("hi tt1");

    }
}
