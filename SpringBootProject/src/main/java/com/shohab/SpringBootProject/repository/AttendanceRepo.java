package com.shohab.SpringBootProject.repository;

import com.shohab.SpringBootProject.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepo extends JpaRepository<Attendance,Integer> {

}
