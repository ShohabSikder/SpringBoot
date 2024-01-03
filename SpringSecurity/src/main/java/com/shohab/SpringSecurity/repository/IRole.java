package com.shohab.SpringSecurity.repository;

import com.shohab.SpringSecurity.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRole extends JpaRepository<Role,Integer> {
}
