package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@SpringBootApplication
@ComponentScan
public class Application implements CommandLineRunner {

	@Autowired
	ApplicationContextProvider ApplicationContextProvider;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String...args) throws Exception {
		MusicPlayer player = this.ApplicationContextProvider.getApplicationContext().getBean("musicPlayer", MusicPlayer.class);
		player.playMusic(Genre.ROCK);
	}


}
