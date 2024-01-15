package com.shohab.SpringBootProject.repository;

import com.shohab.SpringBootProject.model.Advance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvanceRepo extends JpaRepository<Advance,Integer> {
}
