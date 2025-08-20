package com.homework;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.homework.entity.Employee;
import com.homework.mapper.EmpMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Day06ApplicationTests {
    @Resource
    private EmpMapper empMapper;
    @Test
    void selectAge() {
        LambdaQueryWrapper<Employee> wrapper=new LambdaQueryWrapper();
        wrapper.between(Employee::getAge,22,30).eq(Employee::getGender,"男");
        empMapper.selectList(wrapper).forEach(System.out::println);
    }
    @Test
    void selectDept(){
        LambdaQueryWrapper<Employee> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Employee::getGender,"女").and(w-> w.eq(Employee::getDeptName,"市场部")
                .or().eq(Employee::getDeptName,"销售部"));
        empMapper.selectList(wrapper).forEach(System.out::println);
    }
    @Test
    void selectAddr(){
        LambdaQueryWrapper<Employee> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(Employee::getAddr,"长春").eq(Employee::getStatus,1);
        empMapper.selectList(wrapper).forEach(System.out::println);
    }
    @Test
    void selectLoginName(){
        LambdaQueryWrapper<Employee> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(Employee::getLoginName,"admin").and(w->w.eq(Employee::getGender,"男")
                .or().eq(Employee::getDeptName,"人事部"));
        empMapper.selectList(wrapper).forEach(System.out::println);
    }
    @Test
    void selectPage(){
        LambdaQueryWrapper<Employee> wrapper = new LambdaQueryWrapper<>();
        Page<Employee> page = new Page<>(1, 5);
        wrapper.orderByDesc(Employee::getAge);
        empMapper.selectPage(page,wrapper);
    }
}
