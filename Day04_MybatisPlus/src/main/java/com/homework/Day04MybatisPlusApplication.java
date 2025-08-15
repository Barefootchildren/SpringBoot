package com.homework;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.homework.mapper")
public class Day04MybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(Day04MybatisPlusApplication.class, args);
    }

}
