package com.challenge.entity;

import java.security.Timestamp;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedDate;
import lombok.Data;

@Entity
public @Data class Candidate {

    @EmbeddedId
    @ManyToOne
    private User user;

    @EmbeddedId
    @ManyToOne
    private Acceleration acceleration;

    @EmbeddedId
    @ManyToOne
    private  Company company;

    @NotNull
    private int status;

    @CreatedDate
    @Column(name = "created_at")
    private Timestamp created_at;
    
}