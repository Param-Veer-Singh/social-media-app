package com.example.socialmediaapp.Controller;

import com.example.socialmediaapp.Models.Message;
import com.example.socialmediaapp.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/send")
    public ResponseEntity sendMessage(@RequestBody Message message, @RequestParam Integer userId){
        try{
            return messageService.sendMessage(message,userId);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get")
    public List<Message> getMessage(@RequestParam Integer userId) throws Exception {
        return messageService.getMessages(userId);
    }
}
