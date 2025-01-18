package com.example.esarest.beans;

import com.example.esarest.dto.SongDto;
import com.example.esarest.entities.Album;
import com.example.esarest.entities.Artist;
import com.example.esarest.entities.Song;
import com.example.esarest.mappers.SongMapper;
import com.example.esarest.repositories.SongRepository;
import com.example.esarest.services.SongService;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceBean implements SongService {

    private final SongRepository songRepository;
    private final AlbumServiceBean albumServiceBean;
    private final ArtistServiceBean artistServiceBean;

    @Autowired
    public SongServiceBean(SongRepository songRepository, AlbumServiceBean albumServiceBean,
        ArtistServiceBean artistServiceBean) {
        this.songRepository = songRepository;
        this.albumServiceBean = albumServiceBean;
        this.artistServiceBean = artistServiceBean;
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
            Artist artist = artistServiceBean.findById(song.getArtist().getId());
            Album album = null;
            if (song.getAlbum() != null) {
                album = albumServiceBean.findById(song.getAlbum().getId());
            }

            xmlBuilder.append("<song>")
                .append("<artist>").append(artist.getName()).append("</artist>")
                .append("<name>").append(song.getName()).append("</name>")
                .append("<album>").append(album != null ? album.getName() : "").append("</album>")
                .append("<duration>").append(String.format("%s:%s", song.getDuration()/60, song.getDuration()%60)).append("</duration>")
                .append("<explicitContent>").append(song.getExplicitContent() ? "!" : "").append("</explicitContent>")
                .append("</song>");
        }
        xmlBuilder.append("</songs>");
        return xmlBuilder.toString();
    }
}

