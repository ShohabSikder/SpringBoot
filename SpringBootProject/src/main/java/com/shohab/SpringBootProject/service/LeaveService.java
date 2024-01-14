package com.shohab.SpringBootProject.service;

import com.shohab.SpringBootProject.model.EmployeeModel;
import com.shohab.SpringBootProject.model.Leave;
import com.shohab.SpringBootProject.repository.LeaveRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveService {
    @Autowired
    private LeaveRepo leaveRepo;
    public  void saveLeave(Leave leave){
        leaveRepo.save(leave);

    }

    public List<Leave> getAllLeave(){
        return  leaveRepo.findAll();
    }
    public  void deleteById(int id){
        leaveRepo.deleteById(id);
    }

    public Leave findBy(int id){
        return leaveRepo.findById(id).get();
    }
}
