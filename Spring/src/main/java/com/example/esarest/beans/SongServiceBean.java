package com.example.esarest.beans;

import com.example.esarest.entities.Artist;
import com.example.esarest.entities.Song;
import com.example.esarest.repositories.SongRepository;
import com.example.esarest.services.SongService;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceBean implements SongService {

    private final SongRepository songRepository;

    @Autowired
    public SongServiceBean(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public Song findById(UUID id) {
        return songRepository.findById(id).orElseThrow(
            () -> new RuntimeException("No song found with id: " + id)
        );
    }

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public void save(Song entity) {
        songRepository.save(entity);
    }

    @Override
    public void delete(UUID id) {
        songRepository.findById(id).orElseThrow(
            () -> new RuntimeException("No song found with id: " + id)
        );
        songRepository.deleteById(id);
    }

    @Override
    public void update(Song entity) {
        songRepository.findById(entity.getId()).orElseThrow(
            () -> new RuntimeException("No song found with id: " + entity.getId())
        );
        songRepository.save(entity);
    }

    @Override
    public List<Song> getSongsByArtist(Artist artist) {
        return songRepository.findSongsByArtist(artist.getId());
    }
}

