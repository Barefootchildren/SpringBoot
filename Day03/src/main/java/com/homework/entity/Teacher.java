package com.homework.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "com.homework.entity.teacher")
public class Teacher {
    private String name;
    private String gender;
    private int age;
}
