package com.homework.controller;

import com.homework.entity.Student;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Tag(name = "学生接口")
@RestController
@RequestMapping("/student")
public class Controller {
    //查
    @GetMapping
    @Operation(summary = "查询所有学生")
    public Object select(){
        List<Student> students=new ArrayList<>();
        students.add(new Student(1,"张三",20,"男"));
        students.add(new Student(1,"张四",20,"男"));
        students.add(new Student(1,"张五",20,"男"));
        students.add(new Student(1,"张六",20,"男"));
        return students;
    }
    //删
    @DeleteMapping("/{id}")
    @Operation(summary = "通过ID删除学生信息")
    public Object delete(@Parameter(name="id",description = "学生ID",required = true) @PathVariable int id){
        return "已删除ID为"+id+"的信息";
    }
    //增
    @PostMapping
    @Operation(summary = "新增学生信息")
    public Object save(Student student){
        return student;
    }
    //改
    @PutMapping("/{id}")
    @Operation(summary = "更新学生信息")
    public Object update(int id){
        return "已更新ID为"+id+"的学生信息";
    }
}
