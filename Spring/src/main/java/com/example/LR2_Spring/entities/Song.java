package com.example.LR2_Spring.entities;

import com.example.LR2_Spring.entities.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity(name = "esa$Songs")
@Table(name = "ESA_SONGS")
public class Song implements BaseEntity<UUID> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private UUID id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DURATION")
    private Long duration;

    @Column(name = "EXPLICIT_CONTENT")
    private Boolean explicitContent;

    @ManyToOne
    @JoinColumn(name = "ALBUM_ID")
    private Album album;

    @ManyToOne
    @Column(name = "ARTIST_ID")
    private Artist artist;

    public Song(UUID id, String name, Long duration, Boolean explicitContent, Album album,
        Artist artist) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.explicitContent = explicitContent;
        this.album = album;
        this.artist = artist;
    }

    public Song() {

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

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Boolean getExplicitContent() {
        return explicitContent;
    }

    public void setExplicitContent(Boolean explicitContent) {
        this.explicitContent = explicitContent;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}
