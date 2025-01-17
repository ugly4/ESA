package com.example.esarest.repositories.custom;

import com.example.esarest.entities.Artist;
import com.example.esarest.entities.Song;
import java.util.List;

public interface SongRepositoryCustom {
    List<Song> findSongsByArtist(Artist artist);
}
