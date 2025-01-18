package com.example.esarest.entities;


import com.example.esarest.entities.base.BaseEntity;
import jakarta.persistence.*;
import java.util.UUID;

@Entity(name = "esa$Artists")
@Table(name = "ESA_ARTISTS")
public class Artist implements BaseEntity<UUID> {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.UUID)
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
