package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MyController {

    @RequestMapping("/t1")
    public String t1(@RequestParam Integer id,
                     @RequestParam (defaultValue = "Tim",name="t1name")String name){
        System.out.println("id:"+id);
        System.out.println("name:"+name);
        return "hi t1";
    }
}
