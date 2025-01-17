package com.example.LR2_Spring.repositories;

import com.example.LR2_Spring.entities.Song;
import com.example.LR2_Spring.repositories.custom.SongRepositoryCustom;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, UUID>, SongRepositoryCustom {

}
