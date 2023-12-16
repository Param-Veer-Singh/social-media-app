package com.example.socialmediaapp.Models;

import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Table
@Builder
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true,nullable = false)
    private String adminName;
    @Column(unique = true,nullable = false)
    private String email;
    private String adminPassword;
}
