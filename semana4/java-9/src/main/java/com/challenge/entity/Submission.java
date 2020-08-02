package com.challenge.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedDate;
import lombok.Data;

@Entity
public @Data class Submission {

    @EmbeddedId
    @ManyToOne
    private User user;

    @EmbeddedId
    @ManyToOne
    private Challenge challenge;

    @NotNull
    private float score;

    @Column(name = "created_at")
    @CreatedDate
    private Timestamp created_at;
    
}