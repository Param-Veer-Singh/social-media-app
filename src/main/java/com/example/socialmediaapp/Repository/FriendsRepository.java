package com.example.socialmediaapp.Repository;

import com.example.socialmediaapp.Models.Friends;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendsRepository extends JpaRepository<Friends,Integer> {
}
