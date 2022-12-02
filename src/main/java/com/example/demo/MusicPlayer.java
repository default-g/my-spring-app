package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MusicPlayer {

    private List<Music> playList;

    @Autowired
    public MusicPlayer(List<Music> playList) {
        this.playList = playList;
        this.playMusic();
    }
    public void playMusic() {
        System.out.println("Now playing: * " + playList.toString());
    }

}