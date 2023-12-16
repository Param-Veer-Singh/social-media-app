package com.example.socialmediaapp.Service;

import com.example.socialmediaapp.Models.Notification;
import com.example.socialmediaapp.Models.User;
import com.example.socialmediaapp.Repository.NotificationRepository;
import com.example.socialmediaapp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private UserRepository userRepository;

    public ResponseEntity addNotification(String notificationContent, Integer userId) throws Exception {
        User user = userRepository.findById(userId).get();
//        if(notificationDto.getNotificationMessage() == null){
//            throw new Exception("message cannot be null");
//        }
        if(user == null){
            throw new Exception("User not found");
        }

        Notification notification = Notification.builder().notificationMessage(notificationContent)
                .createdDateTime(LocalDateTime.now()).isRead(false).user(user)
                .build();

        notificationRepository.save(notification);
        return new ResponseEntity<>("Notification added", HttpStatus.OK);
    }

    public List<Notification> getNotification(Integer userId) throws Exception {

        User user = userRepository.findById(userId).get();
        if(user == null){
            throw new Exception("User not available");
        }
        return notificationRepository.findByUser(user);
    }
}
