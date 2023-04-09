package com.example.demo;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @RequestMapping("/t1")
    public String t1(@RequestParam Integer id,
                     @RequestParam (defaultValue = "Tim",name="t1name")String name){
        System.out.println("id:"+id);
        System.out.println("name:"+name);
        return "hi t1";
    }

    @RequestMapping("/t2")
    public String t2(@RequestBody Student student ){
        System.out.println("student id:"+student.getId());
        System.out.println("name:"+student.getName());
        return "hi t2";
    }



}
