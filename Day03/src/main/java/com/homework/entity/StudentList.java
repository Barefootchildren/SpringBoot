package com.homework.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "com.homework.entity.students")
public class StudentList {
    private List<Student> studentList=new ArrayList<>();
}
