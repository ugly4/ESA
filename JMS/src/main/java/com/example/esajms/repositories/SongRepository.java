package com.example.esajms.repositories;

import com.example.esajms.entities.Song;
import com.example.esajms.repositories.custom.SongRepositoryCustom;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, UUID>, SongRepositoryCustom {

}
