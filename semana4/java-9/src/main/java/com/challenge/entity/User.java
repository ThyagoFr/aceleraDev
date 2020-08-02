package com.challenge.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Entity
public @Data class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @NotNull
    @Column(length = 100)
    @Size(max = 100)
    private String fullname;

    @NotBlank
    @NotNull
    @Column(length = 100)
    @Size(max = 100)
    @Email
    private String email;

    @NotBlank
    @NotNull
    @Column(length = 50)
    @Size(max = 50)
    private String nickname;

    @NotBlank
    @NotNull
    @Size(max = 255)
    private String password;


    @NotNull
    @CreatedDate
    @Column(name = "created_at")
    private Timestamp created_at;

    @OneToMany
    private List<Candidate> candidate;


    @OneToMany
    private List<Submission> submission;

}