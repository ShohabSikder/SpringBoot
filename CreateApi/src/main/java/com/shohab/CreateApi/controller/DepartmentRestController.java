package com.shohab.CreateApi.controller;

import com.shohab.CreateApi.model.Department;
import com.shohab.CreateApi.model.Employee;
import com.shohab.CreateApi.repository.IDepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
@CrossOrigin(origins = "http://localhost:4200")

public class DepartmentRestController {

    @Autowired
    public IDepartmentRepo iDepartmentRepo;

    @GetMapping("")
    public List<Department> allDep() {
        return iDepartmentRepo.findAll();
    }

    @PostMapping("")
    public Department saveDep(@RequestBody Department department) {
        return iDepartmentRepo.save(department);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        boolean exist = iDepartmentRepo.existsById(id);
        if (exist) {
            iDepartmentRepo.deleteById(id);
            return new ResponseEntity<>("Department is deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>("Department is not exist", HttpStatus.BAD_REQUEST);
    }




    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable("id") int id, @RequestBody Department department) {
        boolean exist = iDepartmentRepo.existsById(id);

        if (exist) {
            Department department1 = iDepartmentRepo.getById(id);
            department1.setName(department.getName());
            department1.setId(id);
            iDepartmentRepo.save(department);
            return new ResponseEntity<>("Department is Updated", HttpStatus.OK);
        }
        return new ResponseEntity<>("Department is not Exist", HttpStatus.BAD_REQUEST);


    }


}
