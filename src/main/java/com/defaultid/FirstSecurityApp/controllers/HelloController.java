package com.defaultid.FirstSecurityApp.controllers;

import com.defaultid.FirstSecurityApp.models.Person;
import com.defaultid.FirstSecurityApp.security.PersonDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {
    @GetMapping
    public String sayHello() {
        return "hello";
    }

    @GetMapping("/user-info")
    public String showUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Person person = ((PersonDetails)authentication.getPrincipal()).getPerson();
        System.out.println(person);
        return "hello";
    }
}
