package com.example.esarest.services;

import com.example.esarest.entities.Artist;
import com.example.esarest.entities.Song;
import com.example.esarest.services.base.BaseService;
import java.util.List;
import java.util.UUID;

public interface SongService extends BaseService<Song, UUID> {
    List<Song> getSongsByArtist(Artist artist);
}
