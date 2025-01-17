package com.example.LR2_Spring.entities;

import com.example.LR2_Spring.entities.base.BaseEntity;
import jakarta.persistence.*;
import java.util.UUID;

@Entity(name = "esa$Albums")
@Table(name = "ESA_ALBUMS")
public class Album implements BaseEntity<UUID> {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "YEAR")
    private Integer year;

    @Column(name = "GENRE")
    private String genre;

    @Column(name = "LABEL")
    private String label;

    @ManyToOne
    @JoinColumn(name = "ARTIST_ID")
    private Artist artist;

    public Album(UUID id, String name, Integer year, String genre, String label, Artist artist) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.genre = genre;
        this.label = label;
        this.artist = artist;
    }

    public Album() {

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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}
