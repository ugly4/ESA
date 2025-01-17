package com.example.esajms.repositories.impl;

import com.example.esajms.entities.Artist;
import com.example.esajms.entities.Song;
import com.example.esajms.repositories.custom.SongRepositoryCustom;
import jakarta.persistence.EntityManager;
import java.util.List;

public class SongRepositoryImpl implements SongRepositoryCustom {
    private EntityManager entityManager;

    @Override
    public List<Song> findSongsByArtist(Artist artist) {
        String sqlString =
            "SELECT e FROM esa$Songs e" +
            "   WHERE e.artist.id = :artistId";

        return entityManager.createQuery(sqlString, Song.class)
            .setParameter("artistId", artist.getId())
            .getResultList();
    }
}
