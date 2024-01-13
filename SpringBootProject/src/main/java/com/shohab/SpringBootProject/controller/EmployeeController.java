package com.shohab.SpringBootProject.controller;

import com.shohab.SpringBootProject.model.Department;
import com.shohab.SpringBootProject.model.EmployeeModel;
import com.shohab.SpringBootProject.service.DepartmentService;
import com.shohab.SpringBootProject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("")
    public  String allEmployee(Model m){
        List<EmployeeModel> employeeList=employeeService.getAllEmployee();
        m.addAttribute("employeeList", employeeList);
        m.addAttribute("title", "All Employee");
        return  "allemployee";
    }


//    @GetMapping("/header")
//    public String showHeader() {
//        return "header.html";
//    }
    @GetMapping("/addform")
    public  String addEmployee(Model m){
// data comes from Department table using List, DepartmentService
        List<Department>depList=departmentService.getAllDepartment();
        // to add department as dropdown from Department Model using Join Querry
        m.addAttribute("department",new Department());
        m.addAttribute("deplist",depList);
        System.out.println(depList);

        //Student Part
        m.addAttribute("employee", new EmployeeModel());
        m.addAttribute("title", "Add Employee");
        return  "addemployee";
    }
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute EmployeeModel e) {
        employeeService.saveEmployee(e);
        return "redirect:/employee";
    }

    @RequestMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id){
        employeeService.deleteById(id);
        return "redirect:/employee";
    }

    @RequestMapping("/edit/{id}")
    public String editEmployee(@PathVariable int id, Model m){
        EmployeeModel e=employeeService.findBy(id);
        m.addAttribute("employee", e);
        return "addemployee";

    }

}
