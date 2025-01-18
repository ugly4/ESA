package com.example.LR2_Spring.beans;

import com.example.LR2_Spring.entities.Artist;
import com.example.LR2_Spring.repositories.ArtistRepository;
import com.example.LR2_Spring.services.base.BaseService;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceBean implements BaseService<Artist, UUID> {

    private final ArtistRepository artistRepository;

    @Autowired
    public ArtistServiceBean(ArtistRepository libraryRepository) {
        this.artistRepository = libraryRepository;
    }

    @Override
    public Artist findById(UUID id) {
        return artistRepository.findById(id).orElseThrow(
                () -> new RuntimeException("No artist found with id: " + id)
        );
    }

    @Override
    public List<Artist> findAll() {
        return artistRepository.findAll();
    }

    @Override
    public void save(Artist entity) {
        artistRepository.save(entity);
    }

    @Override
    public void delete(UUID id) {
        artistRepository.findById(id).orElseThrow(
                () -> new RuntimeException("No artist found with id: " + id)
        );
        artistRepository.deleteById(id);
    }

    @Override
    public void update(Artist entity) {
        artistRepository.findById(entity.getId()).orElseThrow(
                () -> new RuntimeException("No artist found with id: " + entity.getId())
        );
        artistRepository.save(entity);
    }
}
