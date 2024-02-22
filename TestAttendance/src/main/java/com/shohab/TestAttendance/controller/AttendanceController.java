package com.shohab.TestAttendance.controller;

import com.shohab.TestAttendance.model.Attendance;
import com.shohab.TestAttendance.repository.EmployeeRepository;
import com.shohab.TestAttendance.service.AttendanceService;
import com.shohab.TestAttendance.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @GetMapping("/checkIn")
    public String showCheckInForm(Model model) {
        model.addAttribute("attendance", new Attendance());
        return "attendance"; // Assuming you have a Thymeleaf template named "checkInForm.html"
    }

    @PostMapping("/checkIn")
    public String checkIn(@RequestParam Long employeeId) {
        attendanceService.checkIn(employeeId);
        return "redirect:/attendance";
    }

    @GetMapping("/checkOut")
    public String showCheckOutForm(Model model) {
        model.addAttribute("attendance", new Attendance());
        return "attendance"; // Assuming you have a Thymeleaf template named "checkOutForm.html"
    }

    @PostMapping("/checkOut")
    public String checkOut(@RequestParam Long employeeId) {
        attendanceService.checkOut(employeeId);
        return "redirect:/attendance";
    }

    @GetMapping("/attendances")
    public String getAllAttendances(Model model) {
        model.addAttribute("attendances", attendanceService.getAllAttendances());
        return "allattendance"; // Assuming you have a Thymeleaf template named "attendances.html"
    }
}













