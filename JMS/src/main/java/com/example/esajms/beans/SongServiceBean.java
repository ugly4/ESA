package com.example.esajms.beans;

import com.example.esajms.audit.service.AuditService;
import com.example.esajms.dto.SongDto;
import com.example.esajms.entities.Album;
import com.example.esajms.entities.Artist;
import com.example.esajms.entities.Song;
import com.example.esajms.mappers.SongMapper;
import com.example.esajms.repositories.SongRepository;
import com.example.esajms.services.AlbumService;
import com.example.esajms.services.SongService;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceBean implements SongService {

    private final SongRepository songRepository;
    private final ArtistServiceBean artistServiceBean;
    private final AlbumService albumService;
    private final AuditService auditService;

    @Autowired
    public SongServiceBean(SongRepository songRepository, AuditService auditService,
        ArtistServiceBean artistServiceBean, AlbumService albumService) {
        this.songRepository = songRepository;
        this.auditService = auditService;
        this.artistServiceBean = artistServiceBean;
        this.albumService = albumService;
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
        Song song = SongMapper.toEntity(dto);
        Artist artist = artistServiceBean.findById(dto.getArtist());
        Album album = albumService.findById(dto.getAlbum());
        song.setArtist(artist);
        song.setAlbum(album);
        song = songRepository.save(song);
        auditService.insertAuditEvent(song);
    }

    @Override
    public void delete(UUID id) {
        Song song = songRepository.findById(id).orElseThrow(
            () -> new RuntimeException("No song found with id: " + id)
        );
        songRepository.deleteById(id);
        auditService.deleteAuditEvent(song);
    }

    @Override
    public void update(Song entity) {
        songRepository.findById(entity.getId()).orElseThrow(
            () -> new RuntimeException("No song found with id: " + entity.getId())
        );
        Song song = songRepository.save(entity);
        auditService.updateAuditEvent(song);
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
                .append("<album>").append(song.getAlbum() != null ? song.getAlbum().getName() : "").append("</album>")
                .append("<duration>").append(String.format("%s:%s", song.getDuration()/60, song.getDuration()%60)).append("</duration>")
                .append("<explicitContent>").append(song.getExplicitContent() ? "!" : "").append("</explicitContent>")
                .append("</song>");
        }
        xmlBuilder.append("</songs>");
        return xmlBuilder.toString();
    }
}

