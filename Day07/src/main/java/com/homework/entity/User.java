package com.homework.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.homework.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TableName("day07user")
public class User extends Model<User> {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String name;
    @TableField(select = false)
    private String password;
    private UserStatus status;
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
