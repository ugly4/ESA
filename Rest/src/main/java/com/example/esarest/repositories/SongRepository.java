package com.example.esarest.repositories;

import com.example.esarest.entities.Song;
import com.example.esarest.repositories.custom.SongRepositoryCustom;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, UUID>, SongRepositoryCustom {

}
