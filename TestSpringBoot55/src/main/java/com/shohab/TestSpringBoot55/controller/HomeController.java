package com.shohab.TestSpringBoot55.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "spring";
    }
    @GetMapping("/jee")
    public String jee(){
        return "jee";
    }
}
