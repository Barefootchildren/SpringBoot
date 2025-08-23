package com.homework.generator.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI projectOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("SpringBootDay08作业项目")
                .description("项目描述信息")
                .version("1.0")
                .contact(new Contact()
                        .name("Liu")
                        .url("http://www.baidu.com")
                        .email("372236954@qq.com")));
    }
    @Bean
    public GroupedOpenApi defaultApi() {
        return GroupedOpenApi.builder()
                .group("default")
                .packagesToScan("com.homework.generator.controller")
                .build();
    }
}
