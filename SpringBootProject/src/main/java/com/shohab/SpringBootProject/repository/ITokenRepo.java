package com.shohab.SpringBootProject.repository;

import com.shohab.SpringBootProject.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITokenRepo extends JpaRepository<Token,Long> {
    Token findByConfirmationToken(String token);
}
