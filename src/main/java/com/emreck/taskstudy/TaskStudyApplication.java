package com.emreck.taskstudy;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TaskStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskStudyApplication.class, args);
	}

	@Bean//bu nesneden birtane oluştur ve springin ios conteinerine koy herkes erişsin anlamına geliyor.(autowired)
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}

}
