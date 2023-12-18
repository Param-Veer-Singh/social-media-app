package com.example.socialmediaapp.Controller;

import com.example.socialmediaapp.Models.Post;
import com.example.socialmediaapp.Models.User;
import com.example.socialmediaapp.Service.PostService;
import com.example.socialmediaapp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/createPost")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity createPost(@RequestBody Post post, @RequestParam String email){
        try{
            return postService.createPost(post, email);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/deletePost")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity removePost(@RequestParam Integer id, @RequestParam String email){
        try{
            return postService.removePost(id,email);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
