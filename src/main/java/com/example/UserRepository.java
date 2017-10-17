package com.example;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}