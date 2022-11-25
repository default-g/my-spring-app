package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context =  new ClassPathXmlApplicationContext("user-bean-config.xml");
		Music music = context.getBean("musicBean", Music.class);
		MusicPlayer player = new MusicPlayer(music);
		player.playMusic();
//		SpringApplication.run(Application.class, args);
	}

}
