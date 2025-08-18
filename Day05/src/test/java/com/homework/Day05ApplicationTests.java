package com.homework;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.homework.entity.Employee;
import com.homework.mapper.EmpMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Day05ApplicationTests {
    @Autowired
    private EmpMapper mapper;
    @Test
    void insert() {
        //插入数据
        mapper.insert(new Employee(null,"刘二","liuer",
                "liuer",28,"男","重庆市主城区",
                "研工部",0,0));
        System.out.println("新增数据成功");
    }
    @Test
    void select(){
        List<Employee> list=mapper.selectList(null);
        list.forEach(System.out::println);
    }
    @Test
    void update(){
        LambdaUpdateWrapper<Employee> wrapper = new LambdaUpdateWrapper<>();
        wrapper.set(Employee::getDeptName,"销售部").eq(Employee::getDeptName,"研工部");
        System.out.println("修改了"+mapper.update(wrapper)+"条数据");
    }
    @Test
    void updateStatus(){
        LambdaUpdateWrapper<Employee> wrapper=new LambdaUpdateWrapper<>();
        wrapper.set(Employee::getStatus,1)
                .and(w->w.like(Employee::getAddr,"吉林").or().like(Employee::getAddr,"长春"))
                .and(w->w.gt(Employee::getAge,50).or().lt(Employee::getAge,30));
        System.out.println("修改了"+mapper.update(wrapper)+"条数据");
    }
    @Test
    void delete(){
        LambdaQueryWrapper<Employee> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(Employee::getGender,"男").ge(Employee::getAge,60);
        System.out.println("逻辑删除了"+mapper.delete(wrapper)+"条数据");
    }
}
