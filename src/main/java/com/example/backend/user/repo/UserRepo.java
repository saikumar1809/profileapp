package com.example.backend.user.repo;

import com.example.backend.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
User findByEmail(String email);
}
