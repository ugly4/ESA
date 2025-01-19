package com.esaee.models;

import com.esaee.converter.UUIDConverter;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.eclipse.persistence.annotations.Convert;
import org.eclipse.persistence.annotations.Converter;

@Entity(name = "esa$Songs")
@Table(name = "ESA_SONGS")
@Converter(name = "uuidConverter", converterClass = UUIDConverter.class)
public class Song {
    @Id
    @Column(name = "ID", nullable = false)
    @Convert("uuidConverter")
    private UUID id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DURATION")
    private Long duration;

    @Column(name = "EXPLICIT_CONTENT")
    private Boolean explicitContent;

    @Column(name = "ALBUM_ID")
    @Convert("uuidConverter")
    private UUID albumId;

    @Column(name = "ARTIST_ID", nullable = false)
    @Convert("uuidConverter")
    private UUID artistId;

    public Song(UUID id, String name, Long duration, Boolean explicitContent, UUID albumId,
        UUID artistId) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.explicitContent = explicitContent;
        this.albumId = albumId;
        this.artistId = artistId;
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

    public UUID getAlbumId() {
        return albumId;
    }

    public void setAlbumId(UUID albumId) {
        this.albumId = albumId;
    }

    public UUID getArtistId() {
        return artistId;
    }

    public void setArtistId(UUID artistId) {
        this.artistId = artistId;
    }
}
