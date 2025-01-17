package com.example.esajms.mappers;


import com.example.esajms.dto.SongDto;
import com.example.esajms.entities.Album;
import com.example.esajms.entities.Artist;
import com.example.esajms.entities.Song;

public class SongMapper {
    public static Song toEntity(SongDto dto) {
        Album album = new Album();
        Artist artist = new Artist();
        Song song = new Song();

        album.setId(dto.getAlbum());
        artist.setId(dto.getArtist());

        song.setAlbum(album);
        song.setArtist(artist);
        song.setName(dto.getName());
        song.setDuration(dto.getDuration());
        song.setExplicitContent(dto.getExplicitContent());

        return song;
    }
}
