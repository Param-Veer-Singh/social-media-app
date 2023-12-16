package com.example.socialmediaapp.Repository;

import com.example.socialmediaapp.Models.Message;
import com.example.socialmediaapp.Models.Notification;
import com.example.socialmediaapp.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message,Integer> {
//    List<Message> findByUser(User user);
}
