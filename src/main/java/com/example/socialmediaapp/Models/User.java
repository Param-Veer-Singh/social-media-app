package com.example.socialmediaapp.Models;

import com.example.socialmediaapp.Enums.Gender;
import com.example.socialmediaapp.Enums.Privacy;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String userName;
    private String bio;

    @Column(unique = true)
    private String userEmail;
    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Privacy privacyType;

    @JsonIgnore
    @OneToMany(mappedBy = "postOwner" ,cascade = CascadeType.ALL)
    private List<Post> userPosts;

    @JsonIgnore
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Comment> comments;

//    @OneToMany(mappedBy = "fromUser", cascade = CascadeType.ALL)
//    @JsonIgnore
//    private List<Message> messages;
}
