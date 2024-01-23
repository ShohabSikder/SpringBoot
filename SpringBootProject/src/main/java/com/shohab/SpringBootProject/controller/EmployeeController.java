package com.shohab.SpringBootProject.controller;

import com.shohab.SpringBootProject.model.Department;
import com.shohab.SpringBootProject.model.EmployeeModel;
import com.shohab.SpringBootProject.repository.DepartmentRepo;
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
    @Autowired
    private DepartmentRepo departmentRepo;


    @GetMapping("")
    public  String allEmployee(Model m){
        List<EmployeeModel> employeeList=employeeService.getAllEmployee();
        List<Department> depList=departmentService.getAllDepartment();

        m.addAttribute("department", depList);
        m.addAttribute("employeeList", employeeList);

        m.addAttribute("title", "All Employee");
        return  "allemployee";
    }


    @GetMapping("/addform")
    public  String addEmployee(Model m){
// data comes from Department table using List, DepartmentService
        List<Department>depList=departmentService.getAllDepartment();
        List<EmployeeModel> employeeList = employeeService.getAllEmployee();


        m.addAttribute("employeeList", employeeList);
//        m.addAttribute("department", depList);
        // to add department as dropdown from Department Model using Join Querry
        m.addAttribute("department",new Department());
        m.addAttribute("deplist",depList);


        //Employee Part
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
        List<Department>depList=departmentService.getAllDepartment();
        // to add department as dropdown from Department Model using Join Querry
        m.addAttribute("department",new Department());
        m.addAttribute("deplist",depList);
        EmployeeModel e=employeeService.findBy(id);
        m.addAttribute("employee", e);
        return "addemployee";

    }
//    @GetMapping("")
//    public String home(){
//        return "addemployee";
//    }

    //ডিপার্টমেন্ট অনুযায়ী নাম দেখানোর জন্য
    @RequestMapping("/department/{id}")
    public String getEmployeesByDepartment(@PathVariable int id, Model model) {
        // Fetch employees by department
        List<EmployeeModel> employees = employeeService.getEmployeesByDepartment(id);

        // Fetch the selected department
        Department department = departmentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        // Fetch all departments to populate the dropdown
        List<Department> departments = departmentRepo.findAll();

        // Add data to the model
        model.addAttribute("department", departments);  // Corrected attribute name
        model.addAttribute("employeeList", employees);
        model.addAttribute("selectedDepartment", department);

        return "allemployee";
    }

//    @GetMapping("")
//    public String showEmployeeList(Model model) {
//        List<EmployeeModel> employeeList = employeeService.getAllEmployee();
//        List<Department> departments = departmentRepo.findAll();
//
//        model.addAttribute("employeeList", employeeList);
//        model.addAttribute("department", departments);
//
//        return "redirect:/employee";
//    }



}
