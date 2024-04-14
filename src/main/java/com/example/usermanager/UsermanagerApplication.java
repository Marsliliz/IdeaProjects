package com.example.usermanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.usermanager.mapper")
@SpringBootApplication
public class UsermanagerApplication {

    public static void main(String[] args) {

        SpringApplication.run(UsermanagerApplication.class, args);
    }

}
