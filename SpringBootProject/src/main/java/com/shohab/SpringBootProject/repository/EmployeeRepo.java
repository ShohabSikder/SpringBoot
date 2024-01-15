package com.shohab.SpringBootProject.repository;

import com.shohab.SpringBootProject.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeModel,Integer> {
    List<EmployeeModel> findByDepartmentId(int id);
}
