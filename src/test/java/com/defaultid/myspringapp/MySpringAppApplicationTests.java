package com.defaultid.myspringapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MySpringAppApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void checkGenreGetting() {
        Music rock = new Rock();
        assert rock.getMusicGenreName() == "ROCK";
    }

}
