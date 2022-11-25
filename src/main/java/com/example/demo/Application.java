package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context =  new ClassPathXmlApplicationContext("user-bean-config.xml");
		MusicPlayer player = context.getBean("musicPlayer", MusicPlayer.class);
		player.playMusic();
		SpringApplication.run(Application.class, args);
	}

}
