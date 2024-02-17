package com.shohab.TestAttendance.controller;

import com.shohab.TestAttendance.model.Attendance;
import com.shohab.TestAttendance.model.Employee;
import com.shohab.TestAttendance.repository.EmployeeRepository;
import com.shohab.TestAttendance.service.AttendanceService;
import com.shohab.TestAttendance.service.EmployeeService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping("")
public class AttendanceController {
//    @Autowired
//    private AttendanceService attendanceService;
//
//    @Autowired
//    private EmployeeService employeeService;
//
//    @Autowired
//    private EmployeeRepository employeeRepository;
//
////    @GetMapping("/attendance")
////    public String showAttendanceForm(Model model) {
////        model.addAttribute("attendance", new Attendance());
////        model.addAttribute("employees", employeeService.getAllEmployees());
////        return "attendance";
////    }
//
//    @GetMapping("/attendance")
//    public String showAttendanceForm(Model model) {
//        model.addAttribute("attendance", new Attendance());
//        model.addAttribute("employees", employeeService.getAllEmployees());
//
//        // Add employee object to the model
//        Employee employee =employeeRepository.findById(1L).orElse(null);
//                model.addAttribute("employee", employee);
//
//        return "attendance";
//    }
//
    @GetMapping("/attendances")
    public String getAllAttendances(Model model) {
        model.addAttribute("attendances", attendanceService.getAllAttendances());
        return "attendances";
    }
////
////    @PostMapping("/checkAttendance")
////    public String checkAttendance(Attendance attendance) {
////        // Save attendance data to the database
////        attendanceService.saveAttendance(attendance);
////        return "redirect:/attendance"; // Redirect to the attendance form after submission
////    }
//
//
//
//    @PostMapping("/checkAttendance")
//    public String checkAttendance(Attendance attendance, HttpServletRequest request) {
//        // Retrieve employee ID from the request parameter
//        Long employeeId = Long.parseLong(request.getParameter("employee.id"));
//
//        // Set the employee ID in the attendance object
//        attendance.getEmployee().setId(employeeId);
//
//        // Set current time for checkIn and checkOut
//        attendance.setCheckIn(LocalDateTime.now());
//        attendance.setCheckOut(LocalDateTime.now());
//
//        // Save attendance data to the database
//        attendanceService.saveAttendance(attendance);
//
//        return "redirect:/attendance"; // Redirect to the attendance form after submission
//    }


    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/attendance")
    public String showAttendanceForm(Model model) {
        // Initialize a new attendance object
        Attendance attendance = new Attendance();

        // Fetch an employee (you may need to adjust this logic)
        Employee employee = employeeService.getEmployeeById(1L); // For example, fetch employee with ID 1

        // Associate the employee with the attendance object
        attendance.setEmployee(employee);

        // Add the attendance object to the model
        model.addAttribute("attendance", attendance);

        // Add other necessary attributes to the model
        model.addAttribute("employees", employeeService.getAllEmployees());

        return "attendance";
    }

    @PostMapping("/checkAttendance")
    public String checkAttendance(Attendance attendance) {
        // Save attendance data to the database
        attendanceService.saveAttendance(attendance);

        // Redirect to the attendance form after submission
        return "redirect:/attendance";
    }
}
