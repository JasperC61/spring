package com.example.demo;


import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
public class StudentController {

    @PostMapping("/student")
    //@RequestMapping(value = "/student",method = RequestMethod.POST)
    public  String create(@RequestBody @Valid Student student){
//        if(student.getId()==null){
//            throw new RuntimeException("id不可為null");
//        }
        return "執行資料庫的create 操作";

    }
    @GetMapping("/student/{studentId}")
    public  String read(@PathVariable @Min(100) Integer studentId ){
        return "執行資料庫的read 操作";
    }
    @PutMapping("/student/{studentId}")
    public String update(@PathVariable Integer studentId,
                         @RequestBody Student student){
        return "執行資料庫的update 操作";
    }
  /*
    @PutMapping("/student/{studentId}")
    public String update(@PathVariable Integer studentId,
                         @RequestBody Student student,
                         @RequestHeader String info){
        return "執行資料庫的update 操作";
    }*/
    @DeleteMapping("/student/{studentId}")
    public  String delete(@PathVariable Integer studentId){
        return "執行資料庫的delete 操作";
    }
}
