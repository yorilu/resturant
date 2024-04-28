package com.resturant;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAspectJAutoProxy(exposeProxy = true)
@SpringBootApplication
@EnableScheduling
public class ResturantApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResturantApplication.class, args);
    }

}
