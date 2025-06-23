package com.projarc.assignment1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SistVendasApplication {
	public static void main(String[] args) {
		SpringApplication.run(SistVendasApplication.class, args);
	}
}
