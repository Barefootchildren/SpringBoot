package com.homework.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "员工信息",description = "对应数据库的员工信息表")
public class Emp {
    @Schema(description = "员工ID",requiredMode = Schema.RequiredMode.REQUIRED,example = "1")
    private int id;
    @Schema(description = "员工姓名",requiredMode = Schema.RequiredMode.AUTO,example = "刘三")
    private String name;
    @Schema(description = "员工地址",requiredMode = Schema.RequiredMode.AUTO,example = "二仙桥成华大道")
    private String addr;
    @Schema(description = "员工部门",requiredMode = Schema.RequiredMode.AUTO,example = "董事长部")
    private String dept;
    @Schema(description = "员工年龄",requiredMode = Schema.RequiredMode.AUTO,example = "20")
    private int age;
}
