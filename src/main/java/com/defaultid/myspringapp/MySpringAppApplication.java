package com.defaultid.myspringapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MySpringAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySpringAppApplication.class, args);
    }

    @Bean
    public int printTestBeanName(TestBean testBean) {
        System.out.println(testBean.getName());
        return 1;
    }



}
