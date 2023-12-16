package com.example.socialmediaapp.Service;

import com.example.socialmediaapp.Models.Comment;
import com.example.socialmediaapp.Models.Post;
import com.example.socialmediaapp.Repository.CommentRepository;
import com.example.socialmediaapp.Repository.PostRepository;
import com.example.socialmediaapp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    public ResponseEntity addComment(String comment,Integer postId) throws Exception {
        Post post = postRepository.findById(postId).get();

        if(post == null)throw new Exception("Post not available");
        else if(comment == null)throw new Exception("Comment cannot be null");

        Comment comment1 = Comment.builder().comment(comment).localDateTime(LocalDateTime.now()).post(post)
                .build();
        post.getComments().add(comment1);

        postRepository.save(post);
        commentRepository.save(comment1);

        return new ResponseEntity<>("Comment added", HttpStatus.OK);
    }

    public ResponseEntity deleteComment(Integer id, String email, Integer postId) throws Exception {
        if(userRepository.findFirstByUserEmail(email) == null || postRepository.findById(postId) == null || commentRepository.findById(id)== null){
            throw new Exception("Comment is not available");
        }

        commentRepository.deleteById(id);

        return new ResponseEntity("Comment deleted !", HttpStatus.OK);
    }


}
