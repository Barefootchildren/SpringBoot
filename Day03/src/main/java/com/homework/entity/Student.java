package com.homework.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
public class Student {
    private String name;
    private String gender;
    private int age;
    private Grades grades;
}
