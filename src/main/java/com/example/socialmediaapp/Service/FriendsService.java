package com.example.socialmediaapp.Service;

import com.example.socialmediaapp.Models.Follow;
import com.example.socialmediaapp.Models.Friends;
import com.example.socialmediaapp.Models.User;
import com.example.socialmediaapp.Repository.FriendsRepository;
import com.example.socialmediaapp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FriendsService {

    @Autowired
    private FriendsRepository friendsRepository;

    @Autowired
    private UserRepository userRepository;
    public ResponseEntity sendFriendRequest(Integer currentUserId, String friendUserName) throws Exception {

        User currentUser = userRepository.findById(currentUserId).get();
        User friendUser = userRepository.findFirstByUserName(friendUserName);

        if(currentUser == null)throw new Exception("Invalid user" );
        else if(friendUser == null)throw new Exception("User not found");

        Friends friends = Friends.builder().currentUser(currentUser).friendUser(friendUser).isFriend(false)
                .build();

        friendsRepository.save(friends);

        return new ResponseEntity("Friend Request Sent ", HttpStatus.OK);
    }


}


