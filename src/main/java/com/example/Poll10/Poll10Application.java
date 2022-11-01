package com.example.Poll10;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Poll10Application {

	public static void main(String[] args) {
		SpringApplication.run(Poll10Application.class, args);
		
	}
	@Bean
	public ModelMapper modelMapper() 
	{
		return new ModelMapper();
	}

}
