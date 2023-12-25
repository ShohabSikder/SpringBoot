package com.shohab.TestSpringBoot55.service;

import com.shohab.TestSpringBoot55.model.Student;
import com.shohab.TestSpringBoot55.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
@Autowired
    private StudentRepo repo;

    public  void saveStudent(Student student){
        repo.save(student);

    }

    public List<Student>getAllStudent(){
         return  repo.findAll();
    }
    public  void deleteById(int id){
        repo.deleteById(id);
    }

    public Student findBy(int id){
        return repo.findById(id).get();
    }
}
