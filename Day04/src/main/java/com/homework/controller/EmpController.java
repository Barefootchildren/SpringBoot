package com.homework.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.homework.entity.Emp;
import com.homework.server.impl.ServerImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emp")
@Tag(name = "Emp API", description = "员工数据管理接口")
public class EmpController {
    @Autowired
    private ServerImpl server;

    @PostMapping
    @Operation(summary = "新增员工信息")
    public Object insert(@Parameter(description = "员工信息",required = true) Emp emp){
        server.insert(emp);
        return "新增员工信息为："+emp;
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "按ID删除员工信息")
    public Object deleteByID(@Parameter(name = "id", description = "员工ID",required = true)@PathVariable int id){
        server.deleteByID(id);
        return "删除的员工ID为："+id;
    }
    @DeleteMapping("/cond")
    @Operation(summary = "按给定条件删除员工信息")
    public Object deleteByCond(@RequestBody Emp emp){
        server.deleteByCond(emp);
        return "删除成功";
    }
    @PutMapping("/{id}")
    @Operation(summary = "按ID更新员工信息")
    public Object updateByID(@Parameter(description = "员工信息",required = true)  Emp emp){
        server.updateByID(emp);
        return "将员工ID："+emp.getId()+"的信息，更新为"+emp;
    }
    @GetMapping
    @Operation(summary = "查询员工所有信息")
    public Object selectAll(@Parameter(description = "分页查询起始页",required = true) int start,@Parameter(description = "分页查询每页数据量",required = true)int size){
        PageHelper.startPage(start,size);
        return new PageInfo<>(server.selectAll());
    }
    @GetMapping("/{id}")
    @Operation(summary = "按ID查询员工信息")
    public Object selectByID(@Parameter(name = "id", description = "员工ID",required = true)@PathVariable int id){
        return "员工ID"+id+"的信息为："+server.selectByID(id).toString();
    }
    @GetMapping("/cond")
    @Operation(summary = "按条件查询员工信息")
    public Object selectByCond(@Parameter(description = "分页查询起始页",required = true) int start,@Parameter(description = "分页查询每页数据量",required = true)int size,@Parameter(description = "员工信息",required = true) Emp emp){
        PageHelper.startPage(start,size);
        return new PageInfo<>(server.selectByCond(emp));
    }
}
