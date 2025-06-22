package com.receita.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ReceitaServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReceitaServiceApplication.class, args);
    }
}