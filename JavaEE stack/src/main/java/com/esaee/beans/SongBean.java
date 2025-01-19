package com.esaee.beans;

import com.esaee.models.Song;
import java.util.List;
import java.util.UUID;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class SongBean {
    @PersistenceContext(unitName = "esa_unit")
    private EntityManager entityManager;

    public void save(Song song) {
        entityManager.persist(song);
    }

    public Song findById(UUID uuid) {
        return entityManager.find(Song.class, uuid);
    }

    public List<Song> findAll() {
        String sqlString =
            "SELECT e FROM esa$Songs e";

        return entityManager.createQuery(sqlString, Song.class).getResultList();
    }

    public List<Song> findSongsByArtist(UUID artistId) {
        String sqlString =
            "SELECT e FROM esa$Songs e" +
            "   WHERE e.artistId = :artistId";

        return entityManager.createQuery(sqlString, Song.class)
            .setParameter("artistId", artistId)
            .getResultList();
    }

    public List<Song> findSongsByAlbum(UUID albumId) {
        String sqlString =
            "SELECT e FROM esa$Songs e" +
            "   WHERE e.albumId = :albumId";

        return entityManager.createQuery(sqlString, Song.class)
            .setParameter("albumId", albumId)
            .getResultList();
    }

    public void delete(UUID songId) {
        entityManager.createQuery("DELETE FROM esa$Songs s where s.id = :songId")
            .setParameter("songId", songId)
            .executeUpdate();
    }
}
