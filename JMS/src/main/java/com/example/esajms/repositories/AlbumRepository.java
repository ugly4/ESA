package com.example.esajms.repositories;

import com.example.esajms.entities.Album;
import com.example.esajms.repositories.custom.AlbumRepositoryCustom;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, UUID>, AlbumRepositoryCustom {

}
