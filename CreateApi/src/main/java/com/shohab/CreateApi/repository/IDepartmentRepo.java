package com.shohab.CreateApi.repository;

import com.shohab.CreateApi.model.Department;
import com.shohab.CreateApi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartmentRepo extends JpaRepository<Department,Integer> {
 Department findByName(String name);


}
