package com.example.LR2_Spring.repositories;

import com.example.LR2_Spring.entities.Artist;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, UUID> {

}
