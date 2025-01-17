package com.example.esarest.beans;

import com.example.esarest.dto.AlbumDto;
import com.example.esarest.entities.Album;
import com.example.esarest.entities.Artist;
import com.example.esarest.mappers.AlbumMapper;
import com.example.esarest.repositories.AlbumRepository;
import com.example.esarest.services.AlbumService;
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
    public void save(AlbumDto dto) {
        albumRepository.save(AlbumMapper.toEntity(dto));
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

    @Override
    public String getAsXml() {
        List<Album> albums = findAll();
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<albums>");
        for (Album album : albums) {
            xmlBuilder.append("<album>")
                .append("<artist>").append(album.getArtist().getName()).append("</artist>")
                .append("<name>").append(album.getName()).append("</name>")
                .append("<year>").append(album.getYear()).append("</year>")
                .append("<genre>").append(album.getGenre()).append("</genre>")
                .append("<label>").append(album.getLabel()).append("</label>")
                .append("</album>");
        }
        xmlBuilder.append("</albums>");
        return xmlBuilder.toString();
    }
}
