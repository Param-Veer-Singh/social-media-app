package com.example.socialmediaapp.Controller;

import com.example.socialmediaapp.Service.FriendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/friends")
public class FriendsController {

    @Autowired
    private FriendsService friendsService;

    @PostMapping("/sendFriendRequest")
    public ResponseEntity sendFriendRequest(@RequestParam Integer currentUserId, @RequestParam String friendUserName){
        try{
            return friendsService.sendFriendRequest(currentUserId,friendUserName);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
