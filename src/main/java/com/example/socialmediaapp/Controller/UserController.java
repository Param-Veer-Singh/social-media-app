package com.example.socialmediaapp.Controller;

import com.example.socialmediaapp.Models.User;
import com.example.socialmediaapp.RequestDtos.AddUserDto;
import com.example.socialmediaapp.RequestDtos.SignInUserDto;
import com.example.socialmediaapp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
//@PreAuthorize("hasAuthority('ROLE_USER')")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signUp")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity signUpUser(@RequestBody AddUserDto user){
        try{
            return userService.signUpUser(user);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/signIn")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity signInUser(@RequestBody SignInUserDto signInUserDto){
        try{
            return userService.signInUser(signInUserDto);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


}
