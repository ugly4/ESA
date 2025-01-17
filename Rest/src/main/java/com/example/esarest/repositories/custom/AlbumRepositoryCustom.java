package com.example.esarest.repositories.custom;

import com.example.esarest.entities.Album;
import com.example.esarest.entities.Artist;
import java.util.List;

public interface AlbumRepositoryCustom {
    List<Album> findAlbumsByArtist(Artist artist);
}
