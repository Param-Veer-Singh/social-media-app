package com.example.socialmediaapp.Repository;

import com.example.socialmediaapp.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findFirstByUserEmail(String email);
}
