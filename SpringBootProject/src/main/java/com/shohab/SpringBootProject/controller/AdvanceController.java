package com.shohab.SpringBootProject.controller;

import com.shohab.SpringBootProject.model.Advance;
import com.shohab.SpringBootProject.model.Attendance;
import com.shohab.SpringBootProject.model.Department;
import com.shohab.SpringBootProject.model.EmployeeModel;
import com.shohab.SpringBootProject.repository.DepartmentRepo;
import com.shohab.SpringBootProject.service.AdvanceService;
import com.shohab.SpringBootProject.service.AttendanceService;
import com.shohab.SpringBootProject.service.DepartmentService;
import com.shohab.SpringBootProject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/advance")
public class AdvanceController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private AdvanceService advanceService;

    @GetMapping("")
    public  String allAdvance(Model m){
        List<Advance> advanceList=advanceService.getAllAdvance();
        m.addAttribute("advanceList", advanceList);
        m.addAttribute("title", "All Advance");
        return  "alladvance";
    }
    @GetMapping("/addform")
    public  String addAdvance(Model m) {
// data comes from Department table using List, DepartmentService
        List<Department> depList = departmentService.getAllDepartment();
        // to add department as dropdown from Department Model using Join Querry
        m.addAttribute("department", new Department());
        m.addAttribute("deplist", depList);

        List<EmployeeModel> employeeList = employeeService.getAllEmployee();
        // to add Employeement as dropdown from Department Model using Join Querry
        m.addAttribute("employee", new EmployeeModel());
        m.addAttribute("employeeList", employeeList);

        //Attendance part
        m.addAttribute("advance", new Advance());
        m.addAttribute("title", "Add Advance");
        return  "addadvance";


    }
    @PostMapping("/save")
    public String saveAdvance(@ModelAttribute Advance advance) {
        advanceService.saveAdvance(advance);
        return "redirect:/advance";
    }

    @RequestMapping("/delete/{id}")
    public String deleteAdvance(@PathVariable int id){
        advanceService.deleteById(id);
        return "redirect:/advance";
    }

    @RequestMapping("/edit/{id}")
    public String editAttendance(@PathVariable int id, Model m){
        List<Department> depList = departmentService.getAllDepartment();
        // to add department as dropdown from Department Model using Join Querry
        m.addAttribute("department", new Department());
        m.addAttribute("deplist", depList);

        List<EmployeeModel> employeeList = employeeService.getAllEmployee();
        // to add Employeement as dropdown from Department Model using Join Querry
        m.addAttribute("employee", new EmployeeModel());
        m.addAttribute("employeeList", employeeList);

        Advance advance=advanceService.editById(id);
        m.addAttribute("advance", advance);
        return "addadvance";

    }

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

        return "alladvance";
    }
}
