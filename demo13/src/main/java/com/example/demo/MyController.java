package com.example.demo;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @RequestMapping("/tt1")
    public String tt1(){
        throw  new RuntimeException("tt1 error");
    }
    @RequestMapping("/tt2")
    public String tt2(){
        throw new IllegalArgumentException("tt2 error");
    }

}
