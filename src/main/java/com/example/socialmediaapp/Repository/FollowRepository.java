package com.example.socialmediaapp.Repository;

import com.example.socialmediaapp.Models.Follow;
import com.example.socialmediaapp.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepository extends JpaRepository<Follow,Integer> {
    Follow findFollowByCurrentUserAndFollowingUser(User currentUser , User followingUser);
}
