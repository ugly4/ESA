package com.example.esarest.services;

import com.example.esarest.entities.Album;
import com.example.esarest.entities.Artist;
import com.example.esarest.services.base.BaseService;
import java.util.List;
import java.util.UUID;

public interface AlbumService extends BaseService<Album, UUID> {
    List<Album> getAlbumsByArtist(Artist artist);
}
