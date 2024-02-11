package com.shohab.CreateApi.repository;

import com.shohab.CreateApi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee ,Long> {

    Optional<Employee> findByName(String name);
}
