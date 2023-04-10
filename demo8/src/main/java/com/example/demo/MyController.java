package com.example.demo;


import org.springframework.web.bind.annotation.*;

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
    @RequestMapping("/t3")
    public String t3(@RequestHeader String info){
        System.out.println("header info:"+info);
        return "h1 t3";
    }



}
