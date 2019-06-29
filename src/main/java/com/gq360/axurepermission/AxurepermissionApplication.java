package com.gq360.axurepermission;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.gq360.axurepermission.module.mapper")
@SpringBootApplication
public class AxurepermissionApplication {

    public static void main(String[] args) {
        SpringApplication.run(AxurepermissionApplication.class, args);
    }

}
