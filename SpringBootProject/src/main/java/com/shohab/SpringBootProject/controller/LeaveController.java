package com.shohab.SpringBootProject.controller;

import com.shohab.SpringBootProject.model.Attendance;
import com.shohab.SpringBootProject.model.Department;
import com.shohab.SpringBootProject.model.EmployeeModel;
import com.shohab.SpringBootProject.model.Leave;
import com.shohab.SpringBootProject.service.AttendanceService;
import com.shohab.SpringBootProject.service.DepartmentService;
import com.shohab.SpringBootProject.service.EmployeeService;
import com.shohab.SpringBootProject.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin/leave")
public class LeaveController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private LeaveService leaveService;

    @GetMapping("")
    public  String allLeave(Model m){
        List<Leave> leaveList=leaveService.getAllLeave();
        m.addAttribute("leaveList", leaveList);
        m.addAttribute("title", "All Leave");
        return  "allleave";
    }
    @GetMapping("/addform")
    public  String addLeave(Model m) {
// data comes from Department table using List, DepartmentService
        List<Department> depList = departmentService.getAllDepartment();
        // to add department as dropdown from Department Model using Join Querry
        m.addAttribute("department", new Department());
        m.addAttribute("deplist", depList);

        List<EmployeeModel> employeeList = employeeService.getAllEmployee();
        // to add Employeement as dropdown from Department Model using Join Querry
        m.addAttribute("employee", new EmployeeModel());
        m.addAttribute("employeeList", employeeList);


        //Leave part
        m.addAttribute("leave", new Leave());
        m.addAttribute("title", "Add Leave");
        return  "addleave";


    }
    @PostMapping("/save")
    public String saveLeave(@ModelAttribute Leave leave) {
        leaveService.saveLeave(leave);
        return "redirect:/leave";
    }

    @RequestMapping("/delete/{id}")
    public String deleteLeave(@PathVariable int id){
        leaveService.deleteById(id);
        return "redirect:/leave";
    }

    @RequestMapping("/edit/{id}")
    public String editLeave(@PathVariable int id, Model m){
        List<Department> depList = departmentService.getAllDepartment();
        // to add department as dropdown from Department Model using Join Querry
        m.addAttribute("department", new Department());
        m.addAttribute("deplist", depList);

        List<EmployeeModel> employeeList = employeeService.getAllEmployee();
        // to add Employeement as dropdown from Department Model using Join Querry
        m.addAttribute("employee", new EmployeeModel());
        m.addAttribute("employeeList", employeeList);

        Leave leave=leaveService.findBy(id);
        m.addAttribute("leave", leave);
        return "addleave";

    }
}
