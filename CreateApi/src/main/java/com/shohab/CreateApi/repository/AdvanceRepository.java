package com.shohab.CreateApi.repository;

import com.shohab.CreateApi.model.Advance;
import com.shohab.CreateApi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AdvanceRepository extends JpaRepository<Advance,Long> {

    Optional<Advance> findByEmployee(Employee employee);
}
