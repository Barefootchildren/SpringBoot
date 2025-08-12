package com.homework.controller;

import com.homework.entity.Buy;
import com.homework.entity.Student;
import com.homework.entity.StudentList;
import com.homework.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/test")
public class Controller {
    @Autowired
    private Teacher teacher;
    @Autowired
    private StudentList students;

    @GetMapping("/showInfo")
    public Map<String,Object> show(){
        List<Student> studentList = students.getStudentList();

        //获取每个学生的平均成绩，返回一个Map
        Map<String,Double> avgScors=studentList.stream().collect(Collectors.toMap(
                Student::getName,
                student -> (student.getGrades().getChinese()+student.getGrades().getMath()+student.getGrades().getEng())/3.0
        ));

        //获取所有学生的语文平均成绩
        OptionalDouble avgChiScors = studentList.stream().mapToInt(student -> student.getGrades().getChinese()).average();

        //将Map以JSON返回给网页
        return Map.of(
                "教师信息：",teacher,
                "学生信息：",students.getStudentList(),
                "每个学生的三科平均成绩：",avgScors,
                "所有学生的语文平均成绩：",avgChiScors
        );
    }
    @Autowired
    private Buy buy;
    @GetMapping("/buy")
    public Object howToBuy(){
       return buy.howToShop();
    }
}
