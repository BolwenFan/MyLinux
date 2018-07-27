package com.atguigu.jqueryeasyui;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@MapperScan(value = "com.atguigu.**.mappers")
@SpringBootApplication
public class EasyuiCrudDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasyuiCrudDemoApplication.class, args);
    }
}
