package com.example.LR2_Spring.services;

import com.example.LR2_Spring.entities.Album;
import com.example.LR2_Spring.entities.Artist;
import com.example.LR2_Spring.services.base.BaseService;
import java.util.List;
import java.util.UUID;

public interface AlbumService extends BaseService<Album, UUID> {
    List<Album> getAlbumsByArtist(Artist artist);
}
