package com.example.socialmediaapp.Controller;

import com.example.socialmediaapp.Models.Message;
import com.example.socialmediaapp.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/send")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity sendMessage(@RequestBody Message message, @RequestParam Integer userId){
        try{
            return messageService.sendMessage(message,userId);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public List<Message> getMessage(@RequestParam Integer userId) throws Exception {
        return messageService.getMessages(userId);
    }
}
