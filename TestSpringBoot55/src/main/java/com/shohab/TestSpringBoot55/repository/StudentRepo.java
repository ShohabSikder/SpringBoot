package com.shohab.TestSpringBoot55.repository;

import com.shohab.TestSpringBoot55.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {

}
