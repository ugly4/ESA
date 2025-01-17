package com.example.esajms.repositories.custom;

import com.example.esajms.entities.Artist;
import com.example.esajms.entities.Song;
import java.util.List;

public interface SongRepositoryCustom {
    List<Song> findSongsByArtist(Artist artist);
}
