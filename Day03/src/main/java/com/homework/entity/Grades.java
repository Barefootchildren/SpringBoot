package com.homework.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
public class Grades {
    private int chinese;
    private int math;
    private int eng;
}
