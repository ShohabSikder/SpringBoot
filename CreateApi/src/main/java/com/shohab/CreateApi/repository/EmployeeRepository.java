package com.shohab.CreateApi.repository;

import com.shohab.CreateApi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee ,Long> {
}
