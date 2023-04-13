package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
public class StudentController {
    @Autowired
    @Qualifier("test1JdbcTemplate")
    private NamedParameterJdbcTemplate test1JdbcTemplate;
    @Autowired
    @Qualifier("test2JdbcTemplate")
    private NamedParameterJdbcTemplate test2JdbcTemplate;


    @PostMapping("/test1/student")
    public String test1Insert(@RequestBody Student student){
        String sql="insert into student(name) value(:studentName)";
        Map<String ,Object> map=new HashMap<>();
        map.put("studentName",student.getName());
        test1JdbcTemplate.update(sql,map);
        return "插入數據到test1資料庫";
    }


    @PostMapping("/test2/student")
    public String test2Insert(@RequestBody Student student){
        String sql="insert into student(name) value(:studentName)";
        Map<String ,Object> map=new HashMap<>();
        map.put("studentName",student.getName());
        test1JdbcTemplate.update(sql,map);
        return "插入數據到test2資料庫";
    }
}
