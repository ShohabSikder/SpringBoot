package com.shohab.SpringBootProject.service;

import com.shohab.SpringBootProject.model.Attendance;
import com.shohab.SpringBootProject.model.Department;
import com.shohab.SpringBootProject.repository.AttendanceRepo;
import com.shohab.SpringBootProject.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
