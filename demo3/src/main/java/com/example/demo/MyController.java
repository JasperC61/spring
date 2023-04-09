package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @RequestMapping("/product")
    public String product(){
        return "1.蘋果 2.芭樂";
    }

    @RequestMapping("/user")
    public String user(){
        return "這是---Jasper";
    }
}
