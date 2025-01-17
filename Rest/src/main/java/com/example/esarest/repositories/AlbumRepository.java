package com.example.esarest.repositories;

import com.example.esarest.entities.Album;
import com.example.esarest.repositories.custom.AlbumRepositoryCustom;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, UUID>, AlbumRepositoryCustom {

}
