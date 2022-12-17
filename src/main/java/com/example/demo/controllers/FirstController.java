package com.example.demo.controllers;

import org.mariuszgromada.math.mxparser.Expression;
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

    @GetMapping("/first/calculator")
    public String calculator(@RequestParam(value = "a", required = true) float a,
                             @RequestParam(value = "b", required = true) float b,
                             @RequestParam(value = "operand", required = true) String operation,
                             Model model) {
        Expression expression = new Expression(a + operation + b);
        model.addAttribute("result", expression.calculate());
        return "calculator";
    }
}
