package com.example.demo;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @RequestMapping("/tt1")
    public String tt1(){
        System.out.println("執行tt1方法");
        return "hi tt1方法";
    }
    @RequestMapping("/tt2")
    public String tt2(){

        System.out.println("執行tt2方法");
        return "hi tt2方法";
    }

}
