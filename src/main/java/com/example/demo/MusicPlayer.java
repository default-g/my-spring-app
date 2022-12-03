package com.example.demo;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class MusicPlayer {
    @Value("${musicPlayer.name}")
    private String name;

    @Autowired
    private ClassicalMusic classicalMusic;

    @Autowired
    private RockMusic rockMusic;

    public void playMusic(Genre genre) {
        List<String> songs = new ArrayList<>();
        Random random = new Random();

        String playedSong = null;
        if (genre == Genre.ROCK) {
            playedSong = this.rockMusic
                    .getSong()
                    .get(random.nextInt() % this.rockMusic.getSong().size());
        }
        if (genre == Genre.CLASSIC) {
            playedSong = this.classicalMusic
                    .getSong()
                    .get(random.nextInt() % this.classicalMusic.getSong().size());
        }
        System.out.println(this.name);
        System.out.println("Now playing: * " + playedSong);
    }

    @PostConstruct
    private void doInit() {
        System.out.println("Bean created!");
    }
    @PreDestroy
    private void doDestroy() {
        System.out.println("Bean destroyed");
    }

}