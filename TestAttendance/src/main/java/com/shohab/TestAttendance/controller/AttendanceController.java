package com.shohab.TestAttendance.controller;

import com.shohab.TestAttendance.model.Attendance;
import com.shohab.TestAttendance.model.Employee;
import com.shohab.TestAttendance.repository.EmployeeRepository;
import com.shohab.TestAttendance.service.AttendanceService;
import com.shohab.TestAttendance.service.EmployeeService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("")
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/attendance")
    public String showAttendanceForm(Model model) {
        model.addAttribute("attendance", new Attendance());
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "attendance";
    }


//
    @GetMapping("/attendances")
    public String getAllAttendances(Model model) {
        model.addAttribute("attendances", attendanceService.getAllAttendances());
        return "attendances";
    }

//    @PostMapping("/checkAttendance")
//    public String checkAttendance(Attendance attendance) {
//        // Save attendance data to the database
//        attendanceService.saveAttendance(attendance);
//        return "redirect:/attendance"; // Redirect to the attendance form after submission
//    }
//
//
//
//@PostMapping("/checkAttendance")
//public String checkAttendance(@ModelAttribute("attendance") Attendance attendance) {
//    try {
//        if (attendance.getCheckIn() != null && attendance.getCheckOut() == null) {
//            // Check-in
//            attendanceService.checkIn(attendance.getEmployee().getId(), attendance.getCheckIn());
//        } else if (attendance.getCheckOut() != null) {
//            // Check-out
//            attendanceService.checkOut(attendance.getEmployee().getId(), attendance.getCheckOut());
//        }
//        return "redirect:/attendance";
//    } catch (Exception e) {
//        // Handle exception
//        return "error"; // Or redirect to an error page
//    }
//}


    @PostMapping("/checkIn")
    public ResponseEntity<String> recordCheckIn(@RequestParam Long employeeId, @RequestParam String checkIn) {
        // Your code to handle check-in recording
        return ResponseEntity.ok("Check-in recorded successfully.");
    }

    @PostMapping("/checkOut")
    public ResponseEntity<String> recordCheckOut(@RequestParam Long employeeId, @RequestParam String checkOut) {
        // Your code to handle check-out recording
        return ResponseEntity.ok("Check-out recorded successfully.");
    }




}
