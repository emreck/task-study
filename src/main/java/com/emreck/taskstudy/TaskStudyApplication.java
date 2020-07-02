package com.emreck.taskstudy;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TaskStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskStudyApplication.class, args);
	}

	@Bean /*Model Mapper nesnesi oluşturulup springin ios containerine koyuluyor. Amaç oluşturulan nesneyi tekrar tekrar
	yaratmayıp heryerden erişebilmek. (Autrowired)*/
	public ModelMapper getModelMapper(){
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper;
	}

}
