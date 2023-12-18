package com.example.socialmediaapp.Controller;

import com.example.socialmediaapp.Service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/follow")
public class FollowController {

    @Autowired
    private FollowService followService;

    @PostMapping("/followUser")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity followUser(@RequestParam Integer currentUser, @RequestParam String followUserName){
        try{
            return followService.followUser(currentUser,followUserName);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/unfollowUser")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity unfollowUser(@RequestParam Integer currentUserId, @RequestParam String followUserName){
        try{
            return followService.unfollowUser(currentUserId,followUserName);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


}
