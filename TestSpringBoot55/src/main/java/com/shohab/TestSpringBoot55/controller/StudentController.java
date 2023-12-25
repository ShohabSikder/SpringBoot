package com.shohab.TestSpringBoot55.controller;

import com.shohab.TestSpringBoot55.model.Department;
import com.shohab.TestSpringBoot55.model.Student;

import com.shohab.TestSpringBoot55.service.DepartmentService;
import com.shohab.TestSpringBoot55.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private DepartmentService service;
    @GetMapping("")
    public  String allStudent(Model m){
        List<Student>studentList=studentService.getAllStudent();
        m.addAttribute("studentList", studentList);
        m.addAttribute("title", "All Student");
        return  "studenthome";
    }
    @GetMapping("/addForm")
    public  String addStudent(Model m){
// data comes from Department table using List, DepartmentService
        List<Department>depList=service.getAllDepartment();
        // to add department as dropdown from Department Model using Join Querry
        m.addAttribute("department",new Department());
        m.addAttribute("deplist",depList);

       //Student Part
     m.addAttribute("student", new Student());
     m.addAttribute("title", "Add Student");
        return  "addstudent";
    }
    @PostMapping("/save")
    public String saveStudent(@ModelAttribute Student s) {
        studentService.saveStudent(s);
        return "redirect:/student";
    }
    @RequestMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id){
        studentService.deleteById(id);
        return "redirect:/student";
    }

    @RequestMapping("/edit/{id}")
    public String editStudent(@PathVariable int id, Model m){
        Student s=studentService.findBy(id);
        m.addAttribute("student", s);
        return "addstudent";
    }

}
