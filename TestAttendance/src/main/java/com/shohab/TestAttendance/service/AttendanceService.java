package com.shohab.TestAttendance.service;

import com.shohab.TestAttendance.model.Attendance;
import com.shohab.TestAttendance.repository.AttendanceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public List<Attendance> getAllAttendances() {
        return attendanceRepository.findAll();
    }

    public void checkIn(Long employeeId) {
        Attendance attendance = new Attendance();
        attendance.setId(employeeId);
        attendance.setCheckIn(LocalDateTime.now());
        attendanceRepository.save(attendance);
    }

    public void checkOut(Long employeeId) {
        Attendance attendance = attendanceRepository.findByEmployeeIdAndCheckOutIsNull(employeeId);
        if (attendance != null) {
            attendance.setCheckOut(LocalDateTime.now());
            attendanceRepository.save(attendance);
        } else {
            throw new IllegalStateException("No check-in recorded for employee with ID: " + employeeId);
        }
    }
    }



