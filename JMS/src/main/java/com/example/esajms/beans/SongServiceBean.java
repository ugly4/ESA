package com.example.esajms.beans;

import com.example.esajms.dto.SongDto;
import com.example.esajms.entities.Artist;
import com.example.esajms.entities.Song;
import com.example.esajms.mappers.SongMapper;
import com.example.esajms.repositories.SongRepository;
import com.example.esajms.services.SongService;
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
    public void save(SongDto dto) {
        songRepository.save(SongMapper.toEntity(dto));
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
        return songRepository.findSongsByArtist(artist);
    }

    @Override
    public String getAsXml() {
        List<Song> songs = findAll();
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<songs>");
        for (Song song : songs) {
            xmlBuilder.append("<song>")
                .append("<artist>").append(song.getArtist().getName()).append("</artist>")
                .append("<name>").append(song.getName()).append("</name>")
                .append("<album>").append(song.getAlbum().getName()).append("</name>")
                .append("<duration>").append(song.getDuration()).append("</duration>")
                .append("<explicitContent>").append(song.getExplicitContent()).append("</explicitContent>")
                .append("</song>");
        }
        xmlBuilder.append("</songs>");
        return xmlBuilder.toString();
    }
}

