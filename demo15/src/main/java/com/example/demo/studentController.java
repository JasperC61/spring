package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class studentController {
    @Autowired
    private NamedParameterJdbcTemplate  namedParameterJdbcTemplate;

    @PostMapping("/student")
    public  String insert(@RequestBody Student student){
        String sql="insert into student(id,name) value(:studentId,:studentName)";
        Map<String,Object> map=new HashMap<>();
        map.put("studentId",student.getId());
        map.put("studentName",student.getName());
        namedParameterJdbcTemplate.update(sql,map);
        return "執行 insert sql";

    }

    @DeleteMapping("/student/{studentId}")
    public  String delete(@PathVariable Integer studentId){
        String sql="delete from student where id=:studentId";
        Map<String,Object> map=new HashMap<>();
        map.put("studentId",studentId);
        namedParameterJdbcTemplate.update(sql,map);
        return "執行 delete sql";

    }
}
