package com.example.esajms.entities;

import com.example.esajms.entities.base.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity(name = "esa$Artists")
@Table(name = "ESA_ARTISTS")
public class Artist implements BaseEntity<UUID> {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "NAME", nullable = false)
    private String name;

    public Artist(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public Artist() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

