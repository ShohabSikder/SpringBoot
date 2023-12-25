package com.shohab.TestSpringBoot55.service;

import com.shohab.TestSpringBoot55.model.Department;
import com.shohab.TestSpringBoot55.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
private DepartmentRepo repo;
    public void saveDepartment(Department d){
        repo.save(d);
    }
    public List<Department>getAllDepartment(){
       return repo.findAll();
    }
    public void deleteById(int id ){
        repo.deleteById(id);
    }
    public Department editById(int id){
        return repo.findById(id).get();
    }
}
