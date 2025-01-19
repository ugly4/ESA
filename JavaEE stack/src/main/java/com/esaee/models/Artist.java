package com.esaee.models;

import com.esaee.converter.UUIDConverter;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.eclipse.persistence.annotations.Convert;
import org.eclipse.persistence.annotations.Converter;

@Entity(name = "esa$Artists")
@Table(name = "ESA_ARTISTS")
@Converter(name = "uuidConverter", converterClass = UUIDConverter.class)
public class Artist {
    @Id
    @Column(name = "ID", nullable = false)
    @Convert("uuidConverter")
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
