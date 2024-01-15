package com.shohab.SpringBootProject.service;

import com.shohab.SpringBootProject.model.EmployeeModel;
import com.shohab.SpringBootProject.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    public  void saveEmployee(EmployeeModel employee){
        employeeRepo.save(employee);

    }

    public List<EmployeeModel> getAllEmployee(){
        return  employeeRepo.findAll();
    }
    public  void deleteById(int id){
        employeeRepo.deleteById(id);
    }

    public EmployeeModel findBy(int id){
        return employeeRepo.findById(id).get();
    }
    public List<EmployeeModel> getEmployeesByDepartment(int id) {
        return employeeRepo.findByDepartmentId(id);
    }
}
