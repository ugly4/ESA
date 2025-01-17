package com.example.esarest.mappers;

import com.example.esarest.dto.ArtistDto;
import com.example.esarest.entities.Artist;

public class ArtistMapper {
    public static Artist toEntity(ArtistDto dto) {
        Artist artist = new Artist();
        artist.setName(dto.getName());

        return artist;
    }
}
