package com.example.esajms.repositories.custom;

import com.example.esajms.entities.Album;
import com.example.esajms.entities.Artist;
import java.util.List;

public interface AlbumRepositoryCustom {
    List<Album> findAlbumsByArtist(Artist artist);
}
