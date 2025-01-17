package com.example.esajms.repositories.impl;

import com.example.esajms.entities.Album;
import com.example.esajms.entities.Artist;
import com.example.esajms.repositories.custom.AlbumRepositoryCustom;
import jakarta.persistence.EntityManager;
import java.util.List;

public class AlbumRepositoryImpl implements AlbumRepositoryCustom {

    private EntityManager entityManager;

    @Override
    public List<Album> findAlbumsByArtist(Artist artist) {
        String sqlString =
            "SELECT e FROM esa$Albums e" +
            "   WHERE e.artist.id = :artistId";

        return entityManager.createQuery(sqlString, Album.class)
            .setParameter("artistId", artist.getId())
            .getResultList();
    }
}
