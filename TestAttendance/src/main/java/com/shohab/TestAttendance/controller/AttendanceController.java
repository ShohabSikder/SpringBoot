package com.shohab.TestAttendance.controller;

import com.shohab.TestAttendance.model.Attendance;
import com.shohab.TestAttendance.service.AttendanceService;
import com.shohab.TestAttendance.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/attendance")
    public String showAttendanceForm(Model model) {
        model.addAttribute("attendance", new Attendance());
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "attendance";
    }
    @GetMapping("/attendances")
    public String getAllAttendances(Model model) {
        model.addAttribute("attendances", attendanceService.getAllAttendances());
        return "attendances";
    }

    @PostMapping("/checkAttendance")
    public String checkAttendance(Attendance attendance) {
        // Save attendance data to the database
        attendanceService.saveAttendance(attendance);
        return "redirect:/attendance"; // Redirect to the attendance form after submission
    }
}
