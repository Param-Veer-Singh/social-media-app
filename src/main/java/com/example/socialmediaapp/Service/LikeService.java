package com.example.socialmediaapp.Service;

import com.example.socialmediaapp.Models.Like;
import com.example.socialmediaapp.Models.Post;
import com.example.socialmediaapp.Models.User;
import com.example.socialmediaapp.Repository.LikeRepository;
import com.example.socialmediaapp.Repository.PostRepository;
import com.example.socialmediaapp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    public ResponseEntity addLike(Like like) throws Exception {
        Post post = like.getPost();
        User user = like.getUser();

        if(postRepository.findById(post.getId()) == null){
            throw new Exception("Post not available");
        }
        likeRepository.save(like);

        return new ResponseEntity("Liked !", HttpStatus.OK);
    }

    public ResponseEntity removeLike(Integer id) throws Exception {

        Like like = likeRepository.findById(id).get();
        if(like == null){
            throw new Exception("Post not available");
        }

        likeRepository.delete(like);
        return new ResponseEntity("Unliked !", HttpStatus.OK);
    }

    public ResponseEntity countLike(Integer postId) throws Exception{
        Post post = postRepository.findById(postId).get();
        if(post == null){
            throw new Exception("Post not available");
        }
        return new ResponseEntity(likeRepository.findByPost(post).size(),HttpStatus.OK);
    }
}
