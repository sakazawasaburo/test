package com.example;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import com.example.User;


@Repository
@Component
public interface UserRepository extends JpaRepository<User, String> {
}