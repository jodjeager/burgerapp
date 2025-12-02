package com.learn.burgerapp;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BurgerappApplication {

	public static void main(String[] args) {
		SpringApplication.run(BurgerappApplication.class, args);
	}

    @Bean
    ModelMapper modelMapper()
	{
       return	new ModelMapper();
	}
	
	
}
