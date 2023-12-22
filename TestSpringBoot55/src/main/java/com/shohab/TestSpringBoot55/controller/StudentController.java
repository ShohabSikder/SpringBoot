package com.shohab.TestSpringBoot55.controller;

import com.shohab.TestSpringBoot55.model.Student;
import com.shohab.TestSpringBoot55.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentRepo repo;
    @GetMapping("")
    public  String allStudent(){
        return  "studenthome";
    }
    @GetMapping("/addForm")
    public  String addStudent(Model m){
     m.addAttribute("student", new Student());
     m.addAttribute("title", "Add Student");
        return  "addstudent";
    }
    @PostMapping("/save")
    public  String saveStudent(@ModelAttribute Student student){
        repo.save(student);
        return  "redirect:/";
    }
}
