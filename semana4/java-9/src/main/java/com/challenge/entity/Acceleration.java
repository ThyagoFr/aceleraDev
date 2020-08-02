package com.challenge.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.springframework.data.annotation.CreatedDate;
import lombok.Data;
import lombok.NonNull;

@Entity
public @Data class Acceleration {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @NonNull
    @Column(length = 100)
    @Size(max = 100)
    private String name;

    @NotBlank
    @NonNull
    @Column(length = 50)
    @Size(max = 50)
    private String slug;

    @EmbeddedId
    @ManyToOne
    private Challenge challenge;

    @CreatedDate
    @Column(name = "created_at")
    private Timestamp created_at;

    @OneToMany
    private List<Candidate> candidate;
}