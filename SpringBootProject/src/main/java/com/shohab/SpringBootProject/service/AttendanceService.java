package com.shohab.SpringBootProject.service;

import com.shohab.SpringBootProject.model.Attendance;
import com.shohab.SpringBootProject.model.User;
import com.shohab.SpringBootProject.repository.AttendanceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

@Service
public class AttendanceService {
    @Autowired
    private AttendanceRepo attendanceRepo;


    public void saveAttendance(Attendance attendance){
        attendanceRepo.save(attendance);
    }
    public List<Attendance> getAllAttendance(){
        return attendanceRepo.findAll();
    }
    public void deleteById(int id ){
        attendanceRepo.deleteById(id);
    }
    public Attendance editById(int id){
        return attendanceRepo.findById(id).get();
    }
    public void checkIn(User user) {
        Attendance attendance = new Attendance();
        attendance.setUser(user);
        attendance.setCheckInTime(LocalDateTime.now());
        attendanceRepo.save(attendance);
    }





    public void checkOut(User user) {
        List<Attendance> userAttendance = attendanceRepo.findByUserId(user.getId());

        if (!userAttendance.isEmpty()) {
            Attendance latestAttendance = userAttendance.get(userAttendance.size() - 1);
            latestAttendance.setCheckOutTime(LocalDateTime.now());

            attendanceRepo.save(latestAttendance);
        } else {
            // Log a message indicating no attendance records were found for the user
            System.out.println("No attendance records found for user with ID: " + user.getId());

            // You can also throw an exception if needed
            // throw new IllegalStateException("No attendance records found for user with ID: " + user.getId());
        }
    }





}
