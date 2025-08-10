package com.homework.entity;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "学生对象", description = "学生对象，用来对应数据库表的Student")
public class Student {
    @Schema(description = "学生ID",requiredMode = Schema.RequiredMode.REQUIRED,example = "1")
    private int id;
    @Schema(description = "学生姓名",requiredMode = Schema.RequiredMode.REQUIRED,example = "张三")
    private String name;
    @Schema(description = "学生年龄",requiredMode = Schema.RequiredMode.REQUIRED,example = "20")
    private int age;
    @Schema(description = "学生性别",requiredMode = Schema.RequiredMode.REQUIRED,example = "男")
    private String gender;
}
