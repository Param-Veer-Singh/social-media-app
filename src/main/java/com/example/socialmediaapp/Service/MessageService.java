package com.example.socialmediaapp.Service;

import com.example.socialmediaapp.Models.Message;
import com.example.socialmediaapp.Models.User;
import com.example.socialmediaapp.Repository.MessageRepository;
import com.example.socialmediaapp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;
    public ResponseEntity sendMessage(Message message,Integer userId) throws Exception {

        User user = userRepository.findById(userId).get();
        if(user == null)throw new Exception("User not available");

        message.setFromUser(user);
        messageRepository.save(message);

        return new ResponseEntity("Message sent", HttpStatus.OK);
    }

    public List<Message> getMessages(Integer userId) throws Exception {
        User user = userRepository.findById(userId).get();
        if(user == null){
            throw new Exception("User not available");
        }

        List<Message> messages = new ArrayList<>();

        for(Message message : messageRepository.findAll()){
            if(message.getFromUser() == user)messages.add(message);
        }

        return messages;
    }
}
