package com.example.LR2_Spring.services;

import com.example.LR2_Spring.entities.Artist;
import com.example.LR2_Spring.entities.Song;
import com.example.LR2_Spring.services.base.BaseService;
import java.util.List;
import java.util.UUID;

public interface SongService extends BaseService<Song, UUID> {
    List<Song> getSongsByArtist(Artist artist);
}
