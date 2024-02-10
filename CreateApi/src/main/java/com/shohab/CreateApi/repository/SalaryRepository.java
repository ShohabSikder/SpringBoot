package com.shohab.CreateApi.repository;

import com.shohab.CreateApi.model.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SalaryRepository extends JpaRepository<Salary,Long> {
}
