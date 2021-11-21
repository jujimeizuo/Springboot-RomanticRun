package com.kdk.romanticrun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.kdk.romanticrun.mapper")
public class RomanticRunApplication {

    public static void main(String[] args) {
        SpringApplication.run(RomanticRunApplication.class, args);
    }

}
