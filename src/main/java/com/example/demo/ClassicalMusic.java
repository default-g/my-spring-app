package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ClassicalMusic implements Music {

    private List<String> songs = Arrays.asList("Requiem", "Ave Maria", "Messiah");
    @Override
    public List<String> getSong() {
        return this.songs;
    }

}