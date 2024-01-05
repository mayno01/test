package com.example.aminehamed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class AminehamedApplication {

	public static void main(String[] args) {
		SpringApplication.run(AminehamedApplication.class, args);
	}

}
