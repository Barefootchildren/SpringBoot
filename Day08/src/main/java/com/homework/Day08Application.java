package com.homework;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.homework.generator.mapper")
public class Day08Application {

    public static void main(String[] args) {
        SpringApplication.run(Day08Application.class, args);
    }

}
