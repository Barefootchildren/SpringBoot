package com.homework;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.Paths;
import java.sql.Types;
import java.util.Collections;

@SpringBootTest
public class GeneratorTest {
    @Test
    void generator() {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/springboot?serverTimezone=GMT%2B8",
                        "root", "793273")
                .globalConfig(builder -> {
                    builder.author("LiuStu") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .outputDir(".\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder ->
                        builder.parent("com.homework") // 设置父包名
                                .moduleName("generator") // 设置父包模块名
                                .pathInfo(Collections.singletonMap(OutputFile.xml, ".\\src\\main\\resources\\mapper")) // 设置mapperXml生成路径
                )
                .strategyConfig(builder ->
                        builder.addInclude("day08channel") // 设置需要生成的表名
                                .entityBuilder().enableChainModel()
                                .enableLombok()
                                .controllerBuilder().enableRestStyle()
                )
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
