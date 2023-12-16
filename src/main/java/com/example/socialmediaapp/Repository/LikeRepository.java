package com.example.socialmediaapp.Repository;

import com.example.socialmediaapp.Models.Like;
import com.example.socialmediaapp.Models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like,Integer> {

    List<Like> findByPost(Post post);
}
