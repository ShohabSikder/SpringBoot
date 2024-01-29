package com.shohab.CreateApi.repository;

import com.shohab.CreateApi.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDepartmentRepo extends JpaRepository<Department,Integer> {
 Department findByName(String name);
}
