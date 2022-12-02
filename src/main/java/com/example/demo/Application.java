package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
@ComponentScan
public class Application {
	public static void main(String[] args) {
//		ClassicalMusic bean = (ClassicalMusic) applicationContext.getBean("classicalMusic");
//		ApplicationContext context = new ClassPathXmlApplicationContext("user-bean-config.xml");
//		ClassicalMusic music = context.getBean("someClassicalMusic", ClassicalMusic.class);
//		music.getSong();
		SpringApplication.run(Application.class, args);
	}

}
