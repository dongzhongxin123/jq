package com.baizhi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@MapperScan("com.baizhi.dao")
@SpringBootApplication
public class SpringBootJG extends SpringBootServletInitializer {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootJG.class, args);
    }
}
