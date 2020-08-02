package com.challenge.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @NotNull
    @Column(length = 100)
    @Size(max = 100)
    private String name;

    @NotBlank
    @NotNull
    @Column(length = 50)
    @Size(max = 50)
    private String slug;

    @CreatedDate
    @Column(name = "created_at")
    private Timestamp created_at;

    @OneToMany
    private List<Candidate> candidate;
    
}