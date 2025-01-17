package com.example.esajms.mappers;

import com.example.esajms.dto.ArtistDto;
import com.example.esajms.entities.Artist;

public class ArtistMapper {
    public static Artist toEntity(ArtistDto dto) {
        Artist artist = new Artist();
        artist.setName(dto.getName());

        return artist;
    }
}
