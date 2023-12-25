package com.shohab.TestSpringBoot55.repository;

import com.shohab.TestSpringBoot55.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,Integer> {
}
