package com.homework.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TableName("day07acc")
public class Acc {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String name;
    private Integer balance;
    @Version
    private Integer version;
}
