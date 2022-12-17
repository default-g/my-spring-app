package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FirstController {
    @GetMapping("hi")
    public String index(@RequestParam(value="name", required = true) String name,
                        Model model) {
        model.addAttribute("name", name);

        return "greetings";
    }
}
