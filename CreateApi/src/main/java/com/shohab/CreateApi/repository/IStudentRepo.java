package com.shohab.CreateApi.repository;

import com.shohab.CreateApi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepo extends JpaRepository<Student,Integer> {
}
