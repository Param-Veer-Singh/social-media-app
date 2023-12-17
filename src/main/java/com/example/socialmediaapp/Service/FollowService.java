package com.example.socialmediaapp.Service;

import com.example.socialmediaapp.Models.Follow;
import com.example.socialmediaapp.Models.User;
import com.example.socialmediaapp.Repository.FollowRepository;
import com.example.socialmediaapp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FollowService {

    @Autowired
    private FollowRepository followRepository;

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity followUser(Integer currentUserId, String followUserName) throws Exception {
        User currentUser = userRepository.findById(currentUserId).get();
        User followUser = userRepository.findFirstByUserName(followUserName);

        if(currentUser == null)throw new Exception("Invalid user" );
        else if(followUser == null)throw new Exception("User not found");
        else if(followUser.getPrivacyType().equals("Private")) throw new Exception("User id is locked");

        Follow follow = Follow.builder().currentUser(currentUser).followingUser(followUser)
                .build();

        followRepository.save(follow);

        return new ResponseEntity("User followed", HttpStatus.OK);
    }

    public ResponseEntity unfollowUser(Integer currentUserId, String followUserName) throws Exception {
        User currentUser = userRepository.findById(currentUserId).get();
        User followUser = userRepository.findFirstByUserName(followUserName);

        Follow follow = followRepository.findFollowByCurrentUserAndFollowingUser(currentUser,followUser);

        if(follow == null)throw new Exception("No such connection found");
        else if(currentUser == null)throw new Exception("Invalid user" );
        else if(followUser == null)throw new Exception("User not found");

        followRepository.delete(follow);

        return new ResponseEntity("Unfollowed !", HttpStatus.OK);
    }
}
