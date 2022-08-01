package com.defaultid.myspringapp;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Rock implements Music {

    private String name;
    @Bean
    public void printMusicGenre() {
        System.out.println(this.getMusicGenreName());
        System.out.println(this.getSong());
    }

    @Override
    public String getSong() {
        return this.name;
    }

    public Rock() {
        this.name = "UNTITLED";
    }

    public Rock(String name) {
        this.name = name;
    }
}
