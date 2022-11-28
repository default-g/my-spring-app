package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public class ClassicalMusic implements Music {

    public void doMyInit() {
        System.out.println("*** INITIALIZING ***");
    }

    public void doMyDestroy() {
        System.out.println("*** DESTROYING ***");
    }
    @Override
    public String getSong() {
        return "Hungarian Rhapsody";
    }

    public static ClassicalMusic createClassicalMusic() {
        System.out.println("Using factory method!");
        return new ClassicalMusic();
    }
}