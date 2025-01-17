package com.example.LR2_Spring.beans;

import com.example.LR2_Spring.entities.Album;
import com.example.LR2_Spring.entities.Artist;
import com.example.LR2_Spring.repositories.AlbumRepository;
import com.example.LR2_Spring.services.AlbumService;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AlbumServiceBean implements AlbumService {

    private final AlbumRepository albumRepository;

    @Autowired
    public AlbumServiceBean(AlbumRepository bookRepository) {
        this.albumRepository = bookRepository;
    }

    @Override
    public Album findById(UUID id) {
        return albumRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("No Album found with id: " + id)
        );
    }

    @Override
    public List<Album> findAll() {
        return albumRepository.findAll();
    }

    @Override
    public void save(Album entity) {
        albumRepository.save(entity);
    }

    @Override
    public void delete(UUID id) {
        albumRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("No Album found with id: " + id)
        );
        albumRepository.deleteById(id);
    }

    @Override
    public void update(Album entity) {
        albumRepository.findById(entity.getId()).orElseThrow(
                () -> new NoSuchElementException("No Album found with id: " + entity.getId())
        );
        albumRepository.save(entity);
    }

    @Override
    public List<Album> getAlbumsByArtist(Artist artist) {
        return albumRepository.findAlbumsByArtist(artist);
    }
}
