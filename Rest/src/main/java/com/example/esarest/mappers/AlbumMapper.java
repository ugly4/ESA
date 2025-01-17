package com.example.esarest.mappers;

import com.example.esarest.dto.AlbumDto;
import com.example.esarest.entities.Album;
import com.example.esarest.entities.Artist;

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
