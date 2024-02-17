package com.shohab.TestAttendance.service;

import com.shohab.TestAttendance.model.Attendance;
import com.shohab.TestAttendance.repository.AttendanceRepository;
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

    public Attendance saveAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }
    public void checkIn(Long employeeId, LocalDateTime checkInTime) {
        Attendance attendance = new Attendance();
        attendance.setId(employeeId);
        attendance.setCheckIn(checkInTime);
        attendanceRepository.save(attendance);
    }

    public void checkOut(Long employeeId, LocalDateTime checkOutTime) {
        Attendance attendance = attendanceRepository.findById(employeeId).get();
        if (attendance != null) {
            attendance.setCheckOut(checkOutTime);
            attendanceRepository.save(attendance);
        } else {
            // Handle error: no check-in recorded for this employee
            throw new IllegalStateException("No check-in recorded for employee with ID: " + employeeId);
        }
    }
    // Other methods for CRUD operations or business logic related to attendance
}
