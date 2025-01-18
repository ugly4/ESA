package com.example.esajms.entities;

import com.example.esajms.entities.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity(name = "esa$Albums")
@Table(name = "ESA_ALBUMS")
public class Album implements BaseEntity<UUID> {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.UUID)
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
    @JoinColumn(name = "ARTIST_ID", nullable = false)
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

    @Override
    public String toString() {
        return "Album{" + "id=" + id + ", name='" + name + '\'' + ", year=" + year + ", genre='"
            + genre + '\'' + ", label='" + label + '\'' + ", artist=" + artist + '}';
    }
}
