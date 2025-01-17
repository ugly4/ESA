package com.esaee.beans;

import com.esaee.models.Album;
import java.util.List;
import java.util.UUID;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AlbumBean {
    @PersistenceContext(unitName = "esa_unit")
    private EntityManager entityManager;

    public void save(Album album) {
        entityManager.persist(album);
    }

    public Album findById(UUID uuid) {
        return entityManager.find(Album.class, uuid);
    }

    public List<Album> findAll() {
        String sqlString =
            "SELECT e FROM esa$Albums e";

        return entityManager.createQuery(sqlString, Album.class).getResultList();
    }

    public List<Album> findAlbumsByArtist(UUID artistId) {
        String sqlString =
            "SELECT e FROM esa$Albums e" +
            "   WHERE e.artistId = :artistId";

        return entityManager.createQuery(sqlString, Album.class)
            .setParameter("artistId", artistId)
            .getResultList();
    }

    public Album findAlbumBySong(UUID songId) {
        String sqlString =
            "SELECT e FROM esa$Albums e" +
            "   WHERE e.id = " +
            "       (SELECT s.albumId FROM esa$Songs s WHERE s.id = :songId)";

        return entityManager.createQuery(sqlString, Album.class)
            .setParameter("songId", songId)
            .getSingleResult();
    }

    public void delete(UUID albumId) {
        entityManager.createQuery("DELETE FROM esa$Songs s where s.albumId = :albumId")
            .setParameter("albumId", albumId)
            .executeUpdate();

        entityManager.createQuery("DELETE FROM esa$Albums e where e.id = :albumId")
            .setParameter("albumId", albumId)
            .executeUpdate();
    }
}
