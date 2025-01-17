package com.example.esajms.mappers;

import com.example.esajms.dto.AlbumDto;
import com.example.esajms.entities.Album;
import com.example.esajms.entities.Artist;

public class AlbumMapper {
    public static Album toEntity(AlbumDto dto) {
        Artist artist = new Artist();
        Album album = new Album();

        artist.setId(dto.getArtist());
        album.setArtist(artist);
        album.setGenre(dto.getGenre());
        album.setName(dto.getName());
        album.setLabel(dto.getLabel());
        album.setYear(dto.getYear());

        return album;
    }
}
