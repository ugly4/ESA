package com.example.esarest.repositories.impl;

import com.example.esarest.entities.Artist;
import com.example.esarest.entities.Song;
import com.example.esarest.repositories.custom.SongRepositoryCustom;
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
