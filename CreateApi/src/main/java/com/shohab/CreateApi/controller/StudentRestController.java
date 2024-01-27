package com.shohab.CreateApi.controller;

import com.shohab.CreateApi.model.Student;
import com.shohab.CreateApi.repository.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class StudentRestController {
    @Autowired
    IStudentRepo iStudentRepo;

    @GetMapping("/student")
    public List<Student> allStudent(){
        return iStudentRepo.findAll();
    }
    @PostMapping("/student")
    public Student saveStudent(@RequestBody Student student){
        return iStudentRepo.save(student);
    }

    @DeleteMapping("/student/{sid}")
    public ResponseEntity<String> delete(@PathVariable("sid") int id){
        boolean exist=iStudentRepo.existsById(id);
        if(exist){
            iStudentRepo.deleteById(id);
            return  new ResponseEntity<>("Student is deleted", HttpStatus.OK);
        }
        return  new ResponseEntity<>("Student is not exist", HttpStatus.BAD_REQUEST);

    }
    @PutMapping("/student/{sid}")
    public ResponseEntity<String> update(@PathVariable("sid") int id, @RequestBody Student student){
        boolean exist=iStudentRepo.existsById(id);

        if(exist){
            Student student1=iStudentRepo.getById(id);
            student1.setName(student.getName());
            student1.setEmail(student.getEmail());
            student1.setSid(id);
            iStudentRepo.save(student);
            return  new ResponseEntity<>("Student is Updated", HttpStatus.OK);
        }
        return  new ResponseEntity<>("Student is not Exist", HttpStatus.BAD_REQUEST);


    }

}
