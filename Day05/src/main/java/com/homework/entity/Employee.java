package com.homework.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("day05")
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String empName;
    private String loginName;
    @TableField(select = false)
    private String loginPassword;
    private Integer age;
    private String gender;
    private String addr;
    private String deptName;
    private Integer status;
    @TableLogic
    private Integer deleted;
}
