package com.homework.controller;

import com.homework.entity.Emp;
import com.homework.mapper.EmpMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empMybatisPlus")
@Tag(name = "Emp API",description = "员工数据表管理---使用MybatisPlus版")
public class Controller {
    @Autowired
    private EmpMapper mapper;

    @PostMapping
    @Operation(summary = "新增员工信息")
    public Object insert(@Parameter(description = "放入员工信息",required = true)Emp emp){
        mapper.insert(emp);
        return "已添加员工信息："+emp;
    }
    @DeleteMapping
    @Operation(summary = "按ID删除员工信息")
    public Object deleteByID(@Parameter(description = "员工ID",required = true)int id){
        mapper.deleteById(id);
        return "删除成功";
    }
    @GetMapping
    @Operation(summary = "查询所有员工信息")
    public Object selectAll(){
        return "查询到的员工信息为："+mapper.selectList(null);
    }
}
