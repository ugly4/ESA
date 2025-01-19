package com.esaee.beans;

import com.esaee.models.Artist;
import java.util.List;
import java.util.UUID;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ArtistBean {
    @PersistenceContext(unitName = "esa_unit")
    private EntityManager entityManager;

    public void save(Artist artist) {
        entityManager.persist(artist);
    }

    public Artist findById(UUID uuid) {
        return entityManager.find(Artist.class, uuid);
    }

    public List<Artist> findAll() {
        String sqlString =
            "SELECT e FROM esa$Artists e";

        return entityManager.createQuery(sqlString, Artist.class).getResultList();
    }

    public Artist findArtistByName(String name) {
        String sqlString =
            "SELECT e FROM esa$Artists e" +
            "   WHERE e.name = :name";

        return entityManager.createQuery(sqlString, Artist.class)
            .setParameter("name", name)
            .getSingleResult();
    }

    public Artist findArtistByAlbum(UUID albumId) {
        String sqlString =
            "SELECT e FROM esa$Artists e" +
            "   WHERE e.id = " +
            "       (SELECT a.artistId FROM esa$Albums a where a.id = :albumId)";

        return entityManager.createQuery(sqlString, Artist.class)
            .setParameter("albumId", albumId)
            .getSingleResult();
    }

    public Artist findArtistBySong(UUID songId) {
        String sqlString =
            "SELECT e FROM esa$Artists e" +
            "   WHERE e.id = " +
            "       (SELECT s.artistId FROM esa$Songs s WHERE s.id = :songId)";

        return entityManager.createQuery(sqlString, Artist.class)
            .setParameter("songId", songId)
            .getSingleResult();
    }

    public void delete(UUID artistId) {
        entityManager.createQuery("DELETE FROM esa$Songs s where s.artistId = :artistId")
            .setParameter("artistId", artistId)
            .executeUpdate();

        entityManager.createQuery("DELETE FROM esa$Albums e where e.artistId = :artistId")
            .setParameter("artistId", artistId)
            .executeUpdate();

        entityManager.createQuery("DELETE FROM esa$Artists e where e.id = :artistId")
            .setParameter("artistId", artistId)
            .executeUpdate();
    }
}
