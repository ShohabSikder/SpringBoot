package com.shohab.JwtSecurityRestApi.respository;

import com.shohab.JwtSecurityRestApi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
Optional<User>findByEmail(String username);
}
