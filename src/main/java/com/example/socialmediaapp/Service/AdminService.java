package com.example.socialmediaapp.Service;

import com.example.socialmediaapp.Models.Admin;
import com.example.socialmediaapp.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public ResponseEntity addAdmin(Admin admin){
        adminRepository.save(admin);

        return new ResponseEntity("Admin saved", HttpStatus.OK);
    }
}
