package com.example.LR2_Spring.repositories.custom;

import com.example.LR2_Spring.entities.Album;
import com.example.LR2_Spring.entities.Artist;
import java.util.List;

public interface AlbumRepositoryCustom {
    List<Album> findAlbumsByArtist(Artist artist);
}
