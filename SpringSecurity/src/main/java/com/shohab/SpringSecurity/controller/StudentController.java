package com.shohab.SpringSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/student")
public class StudentController {

    @GetMapping("/saveform")
    public String student(){
        return "student";
    }
    @GetMapping("/all")
    public String allStudent(){
        return "viewallstudent";
    }
}
