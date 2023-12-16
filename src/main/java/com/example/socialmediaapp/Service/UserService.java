package com.example.socialmediaapp.Service;

import com.example.socialmediaapp.Models.User;
import com.example.socialmediaapp.Repository.UserRepository;
import com.example.socialmediaapp.RequestDtos.AddUserDto;
import com.example.socialmediaapp.RequestDtos.SignInUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }

    public ResponseEntity signUpUser(AddUserDto user) throws Exception{
        String email = user.getUserEmail();

        if(email == null){
            throw  new Exception("Invalid Email");
        }
        else if(userRepository.findFirstByUserEmail(email) != null){
            throw new Exception("Email id is already registered");
        }
        String encodedPassword = passwordEncoder.encode(user.getPassword());

        User user1 = User.builder().userName(user.getUserName()).bio(user.getBio())
                .userEmail(user.getUserEmail()).password(encodedPassword).gender(user.getGender()).privacyType(user.getPrivacyType())
                .build();

        userRepository.save(user1);

        return new ResponseEntity("New user added", HttpStatus.OK);

    }


 public ResponseEntity signInUser(SignInUserDto user) throws Exception{
        User user1 = userRepository.findFirstByUserEmail(user.getEmail());

        if(user1 == null){
            throw  new Exception("User is not registered");
        }

        if(!user1.getPassword().equals(passwordEncoder.encode(user.getPassword()))){
            throw new Exception("Wrong password");
        }
        return new ResponseEntity("Sign in successfully !", HttpStatus.OK);

    }
}
