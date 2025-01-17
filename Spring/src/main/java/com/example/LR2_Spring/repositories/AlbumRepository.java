package com.example.LR2_Spring.repositories;

import com.example.LR2_Spring.entities.Album;
import com.example.LR2_Spring.repositories.custom.AlbumRepositoryCustom;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, UUID>, AlbumRepositoryCustom {

}
