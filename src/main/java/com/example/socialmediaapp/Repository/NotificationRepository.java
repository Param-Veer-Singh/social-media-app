package com.example.socialmediaapp.Repository;

import com.example.socialmediaapp.Models.Notification;
import com.example.socialmediaapp.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification,Integer> {

    List<Notification> findByUser(User user);
}
