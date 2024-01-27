package com.shohab.SpringBootProject.controller;

import com.shohab.SpringBootProject.model.Attendance;
import com.shohab.SpringBootProject.model.Department;
import com.shohab.SpringBootProject.model.EmployeeModel;
import com.shohab.SpringBootProject.model.User;
import com.shohab.SpringBootProject.repository.AttendanceRepo;
import com.shohab.SpringBootProject.repository.IUserRepository;
import com.shohab.SpringBootProject.service.AttendanceService;
import com.shohab.SpringBootProject.service.DepartmentService;
import com.shohab.SpringBootProject.service.EmployeeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/attendance")
public class AttendanceController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private AttendanceService attendanceService;
    @Autowired
    private AttendanceRepo attendanceRepo;

    @Autowired
    IUserRepository userRepository;



    @GetMapping("")
    public  String allAttendance(Model m){
        List<Attendance> attendanceList=attendanceService.getAllAttendance();
        m.addAttribute("attendanceList", attendanceList);
        m.addAttribute("title", "All Attendance");
        return  "attendance";
    }
    @GetMapping("/addform")
    public  String addAttendance(Model m) {
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
        m.addAttribute("attendance", new Attendance());
        m.addAttribute("title", "Add Attendance");
        return  "attendance";


    }
    @PostMapping("/save")
    public String saveAttendance(@ModelAttribute Attendance attendance) {
        attendanceService.saveAttendance(attendance);
        return "redirect:/attendance";
    }

    @RequestMapping("/delete/{id}")
    public String deleteAttendance(@PathVariable int id){
        attendanceService.deleteById(id);
        return "redirect:/attendance";
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

        Attendance attendance=attendanceService.editById(id);
        m.addAttribute("attendance", attendance);
        return "addattendance";

    }

    @GetMapping("/check-in")
    public String checkIn(Model model) {
        User loggedInUser = userRepository.findById(8).get();
        attendanceService.checkIn(loggedInUser);
        model.addAttribute("userName", loggedInUser.getName());
        return "redirect:/attendance?userName=" + loggedInUser.getName();
    }

    @GetMapping("/check-out")
    public String checkOut(Model model) {
        User loggedInUser = userRepository.findById(8).get();
        attendanceService.checkOut(loggedInUser);
        model.addAttribute("userName", loggedInUser.getName());
        return "redirect:/attendance";
    }




//    private User getCurrentLoggedInUser() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication != null && authentication.getPrincipal() instanceof User) {
//            return (User) authentication.getPrincipal();
//        }
//        // Handle the case where the user is not authenticated or the principal is not of type User
//        return null;
//    }






}
