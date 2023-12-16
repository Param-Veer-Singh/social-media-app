package com.example.socialmediaapp.Repository;

import com.example.socialmediaapp.Models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {
}
