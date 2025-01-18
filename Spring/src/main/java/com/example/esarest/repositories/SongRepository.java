package com.example.esarest.repositories;

import com.example.esarest.entities.Song;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, UUID> {
    @Query(
        "SELECT e FROM esa$Songs e" +
        "   WHERE e.artist.id = :artistId"
    )
    List<Song> findSongsByArtist(UUID artistId);
}
