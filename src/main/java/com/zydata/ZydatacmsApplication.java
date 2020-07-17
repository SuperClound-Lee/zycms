package com.zydata;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("{com.zydata.domain}")
public class ZydatacmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZydatacmsApplication.class, args);
    }

}
