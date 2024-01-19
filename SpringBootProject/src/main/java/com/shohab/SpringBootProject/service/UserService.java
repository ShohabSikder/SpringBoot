package com.shohab.SpringBootProject.service;

import com.shohab.SpringBootProject.model.Attendance;
import com.shohab.SpringBootProject.model.User;
import com.shohab.SpringBootProject.repository.AttendanceRepo;
import com.shohab.SpringBootProject.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AttendanceRepo attendanceRepo;

    public void saveUserAndAttendance() {
        // create or retrieve the user
        User user = new User();
        userRepo.save(user);

        // create or retrieve the attendance
        Attendance attendance = new Attendance();
        attendance.setUser(user);
        attendanceRepo.save(attendance);
    }
}
