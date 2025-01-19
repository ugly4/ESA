package com.esaee.models;

import com.esaee.converter.UUIDConverter;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.eclipse.persistence.annotations.Convert;
import org.eclipse.persistence.annotations.Converter;

@Entity(name = "esa$Albums")
@Table(name = "ESA_ALBUMS")
@Converter(name = "uuidConverter", converterClass = UUIDConverter.class)
public class Album {
    @Id
    @Column(name = "ID", nullable = false)
    @Convert("uuidConverter")
    private UUID id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "YEAR")
    private Integer year;

    @Column(name = "GENRE")
    private String genre;

    @Column(name = "LABEL")
    private String label;

    @Column(name = "ARTIST_ID", nullable = false)
    @Convert("uuidConverter")
    private UUID artistId;

    public Album(UUID id, String name, Integer year, String genre, String label, UUID artistId) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.genre = genre;
        this.label = label;
        this.artistId = artistId;
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

    public UUID getArtistId() {
        return artistId;
    }

    public void setArtistId(UUID artistId) {
        this.artistId = artistId;
    }
}
