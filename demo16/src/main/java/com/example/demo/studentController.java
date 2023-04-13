package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class studentController {
    @Autowired
    private NamedParameterJdbcTemplate  namedParameterJdbcTemplate;

    @PostMapping("/student")
    public  String insert(@RequestBody Student student){
        String sql="insert into student(name) value(:studentName)";
        Map<String,Object> map=new HashMap<>();
       // map.put("studentId",student.getId());
        KeyHolder keyHolder=new GeneratedKeyHolder();

        map.put("studentName",student.getName());
       // namedParameterJdbcTemplate.update(sql,map);
        namedParameterJdbcTemplate.update(sql,new MapSqlParameterSource(map),keyHolder);
        int id=keyHolder.getKey().intValue();
        System.out.println("JasperMysql 自動生成的id:"+id);
        return "執行 insert sql";

    }
   @PostMapping("/student/batch")
    public String insertList(@RequestBody List<Student> studentList){
        String sql="insert into student(name) value(:studentName)";
        MapSqlParameterSource[]  parameterSources=new MapSqlParameterSource[studentList.size()];
        for(int i=0;i<studentList.size();i++){
            Student student=studentList.get(i);
            parameterSources[i]=new MapSqlParameterSource();
            parameterSources[i].addValue("studentName",student.getName());

        }
        namedParameterJdbcTemplate.batchUpdate(sql,parameterSources);
    return "執行一批 insert sql ";
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
