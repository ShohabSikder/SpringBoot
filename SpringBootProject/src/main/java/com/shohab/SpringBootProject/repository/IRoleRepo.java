package com.shohab.SpringBootProject.repository;

import com.shohab.SpringBootProject.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepo extends JpaRepository<Role,Integer> {

}
