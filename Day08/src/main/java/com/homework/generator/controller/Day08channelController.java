package com.homework.generator.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.homework.generator.entity.Day08channel;
import com.homework.generator.service.IDay08channelService;
import com.homework.generator.service.impl.Day08channelServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author LiuStu
 * @since 2025-08-23
 */
@RestController
@RequestMapping("/generator/day08channel")
@Tag(name = "频道管理接口",description = "处理 day08channel 表相关请求")
public class Day08channelController {
    @Autowired
    private IDay08channelService service;

    @GetMapping
    @Operation(summary = "查询所有数据",description = "分页查询")
    Object selectPage(@Parameter(description = "起始页") Integer start,
                    @Parameter(description = "每页多少条数据") Integer num){
        Page<Day08channel> page=new Page<>(start,num);
        return service.page(page);
    }
    @PutMapping
    @Operation(summary = "更新数据",description = "按ID更新数据")
    Object update(@Parameter(description = "需要更新的信息",required = true) Day08channel channel){
        return service.updateById(channel);
    }
    @PostMapping
    @Operation(summary = "新增数据",description = "新增一条频道信息")
    Object insert(@Parameter(description = "需要新增的信息",required = true) Day08channel channel){
        return service.save(channel);
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "删除数据",description = "通过ID删除一条频道信息")
    Object delete(@Parameter(description = "需要删除的数据的ID",required = true) @PathVariable Integer id){
        return service.removeById(id);
    }
}
