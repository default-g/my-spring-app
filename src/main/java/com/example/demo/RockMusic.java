package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class RockMusic implements Music {
    private List<String> songs = Arrays.asList("All Along The Watchtower", "Smells Like Teen Spirit", "Boys Don't Cry");
    @Override
    public List<String> getSong() {
        return this.songs;
    }
}
