package com.example.esajms.dto;

import com.example.esajms.dto.base.BaseDto;
import java.util.UUID;

public class AlbumDto implements BaseDto {
    private String name;

    private Integer year;

    private String genre;

    private String label;

    private UUID artist;

    public String getName() {
        return name;
    }

    public Integer getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public String getLabel() {
        return label;
    }

    public UUID getArtist() {
        return artist;
    }
}
