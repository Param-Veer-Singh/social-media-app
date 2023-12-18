package com.example.socialmediaapp.Controller;

import com.example.socialmediaapp.Models.Admin;
import com.example.socialmediaapp.RequestDtos.AddUserDto;
import com.example.socialmediaapp.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    public ResponseEntity addAdmin(@RequestBody Admin admin){
        try{
            return adminService.addAdmin(admin);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
