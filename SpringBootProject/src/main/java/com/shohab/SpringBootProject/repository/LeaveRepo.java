package com.shohab.SpringBootProject.repository;

import com.shohab.SpringBootProject.model.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveRepo extends JpaRepository<Leave,Integer> {

}
