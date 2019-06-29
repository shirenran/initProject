package com.init.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.init.project.module.mapper")
@SpringBootApplication
public class initProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(initProjectApplication.class, args);
    }

}
