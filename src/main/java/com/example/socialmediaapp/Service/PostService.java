package com.example.socialmediaapp.Service;

import com.example.socialmediaapp.Models.Post;
import com.example.socialmediaapp.Models.User;
import com.example.socialmediaapp.Repository.PostRepository;
import com.example.socialmediaapp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;
    public ResponseEntity createPost(Post post , String userEmail) throws Exception {

        User user = userRepository.findFirstByUserEmail(userEmail);
        if(user == null){
            throw new Exception("User not found");
        }
        Post post1 = Post.builder().content(post.getContent()).caption(post.getCaption()).location(post.getLocation())
                .time(LocalDateTime.now()).postType(post.getPostType()).postOwner(user)
                .build();

        postRepository.save(post1);
        userRepository.save(user);

        return new ResponseEntity("Post uploaded", HttpStatus.OK);
    }

    public ResponseEntity removePost(Integer id, String email) throws Exception {
        Post post = postRepository.findById(id).get();
        User user = userRepository.findFirstByUserEmail(email);

        if(post != null  && user != null && post.getPostOwner().equals(user)){
            postRepository.deleteById(id);

            return new ResponseEntity("Post removed", HttpStatus.OK);
        }else{
            throw new Exception("Post not found");
        }
    }
}
