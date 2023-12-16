package com.example.socialmediaapp.Controller;

import com.example.socialmediaapp.Models.Notification;
import com.example.socialmediaapp.Service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/addNotification")
    public ResponseEntity addNotification(@RequestBody String notification, @RequestParam Integer userId){
        try{
            return notificationService.addNotification(notification,userId);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getNotifications")
    public List<Notification> getNotification(@RequestParam Integer id) throws Exception {
            return notificationService.getNotification(id);
    }
}
