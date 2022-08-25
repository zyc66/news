package com.qihang.news;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan({"com.qihang.news.mapper"} )
public class QhNewsSpringbootApplication {
    public static void main(String[] args) {
        SpringApplication.run(QhNewsSpringbootApplication.class);
    }
}
