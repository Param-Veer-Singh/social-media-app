package com.example.socialmediaapp.Models;

import com.example.socialmediaapp.Enums.PostType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String content;
    private String caption;
    private String location;

    private LocalDateTime time;

    @Enumerated(EnumType.STRING)
    private PostType postType;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private User postOwner;

    @OneToMany(mappedBy = "post" ,cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Comment> comments;

}
