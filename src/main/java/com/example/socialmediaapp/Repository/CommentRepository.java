package com.example.socialmediaapp.Repository;

import com.example.socialmediaapp.Models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CommentRepository extends JpaRepository<Comment,Integer> {
}
