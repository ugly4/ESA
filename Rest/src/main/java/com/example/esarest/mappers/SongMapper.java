package com.example.esarest.mappers;


import com.example.esarest.dto.SongDto;
import com.example.esarest.entities.Album;
import com.example.esarest.entities.Artist;
import com.example.esarest.entities.Song;

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
