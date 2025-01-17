package com.example.esarest.dto;

import com.example.esarest.dto.base.BaseDto;
import java.util.UUID;

public class SongDto implements BaseDto {
    private String name;

    private Long duration;

    private Boolean explicitContent;

    private UUID album;

    private UUID artist;

    public String getName() {
        return name;
    }

    public Long getDuration() {
        return duration;
    }

    public Boolean getExplicitContent() {
        return explicitContent;
    }

    public UUID getAlbum() {
        return album;
    }

    public UUID getArtist() {
        return artist;
    }
}
