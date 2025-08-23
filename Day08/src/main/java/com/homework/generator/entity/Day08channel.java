package com.homework.generator.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author LiuStu
 * @since 2025-08-23
 */
@Data
@ToString
@Accessors(chain = true)
@Schema(name = "Day08channel对象", description = "电台频道数据库管理")
public class Day08channel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 栏目id
     */
    @Schema(description = "栏目id")
    @TableId(value = "cid", type = IdType.AUTO)
    private Integer cid;

    /**
     * 栏目名称
     */
    @Schema(description = "栏目名称")
    private String cname;

    /**
     * 栏目描述
     */
    @Schema(description = "栏目描述")
    @TableField("channel_desc")
    private String channelDesc;

    /**
     * 创建时间
     */
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    @Schema(description = "修改时间")
    private LocalDateTime updateTime;

    /**
     * 是否删除
     */
    @Schema(description = "是否删除")
    private Boolean deleted;
}
