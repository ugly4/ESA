package com.example.LR2_Spring.repositories.custom;

import com.example.LR2_Spring.entities.Artist;
import com.example.LR2_Spring.entities.Song;
import java.util.List;

public interface SongRepositoryCustom {
    List<Song> findSongsByArtist(Artist artist);
}
