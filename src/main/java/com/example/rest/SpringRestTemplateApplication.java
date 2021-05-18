package com.example.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SpringRestTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRestTemplateApplication.class, args);
    }

}
