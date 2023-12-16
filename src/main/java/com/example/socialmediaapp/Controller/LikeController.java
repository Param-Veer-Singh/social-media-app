package com.example.socialmediaapp.Controller;

import com.example.socialmediaapp.Models.Like;
import com.example.socialmediaapp.Service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/like")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @PostMapping("/addLike")
    public ResponseEntity addLike(@RequestBody Like like){
        try{
            return likeService.addLike(like);
        }
        catch(Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/removeLike")
    public ResponseEntity removeLike(@RequestParam Integer id){
        try{
            return likeService.removeLike(id);
        }
        catch(Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/countLike")
    public ResponseEntity countLike(@RequestParam Integer postId){
        try{
            return likeService.countLike(postId);
        }
        catch(Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
