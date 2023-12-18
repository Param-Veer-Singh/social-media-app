package com.example.socialmediaapp.Controller;

import com.example.socialmediaapp.Service.CommentService;
import com.example.socialmediaapp.Service.PostService;
import com.example.socialmediaapp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {


    @Autowired
    private CommentService commentService;

    @PostMapping("/addComment")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity addComment(@RequestBody String comment, @RequestParam Integer postId){
        try{
            return commentService.addComment(comment,postId);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/removeComment")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity removeComment(@RequestParam Integer id, @RequestParam String email, @RequestParam Integer postId){
        try{
            return commentService.deleteComment(id,email,postId);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
