package com.open.orm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liuxiaowei
 * @date 2022年09月20日 15:28
 * @Description
 */
@SpringBootApplication
@MapperScan(basePackages = "com.open.orm.mybatisplus.mapper")
public class HelloOrmApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloOrmApplication.class, args);
    }
}
