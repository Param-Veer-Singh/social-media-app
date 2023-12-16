package com.example.socialmediaapp.RequestDtos;

import com.example.socialmediaapp.Enums.Gender;
import com.example.socialmediaapp.Enums.Privacy;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddUserDto {
    private String userName;
    private String bio;
    private String userEmail;
    private String password;
    private Gender gender;
    private Privacy privacyType;
}
