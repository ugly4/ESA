package com.example.esarest.beans;

import com.example.esarest.dto.ArtistDto;
import com.example.esarest.entities.Artist;
import com.example.esarest.mappers.ArtistMapper;
import com.example.esarest.repositories.ArtistRepository;
import com.example.esarest.services.base.BaseService;
import com.example.esarest.services.base.XmlConvertService;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceBean implements BaseService<Artist, ArtistDto, UUID>, XmlConvertService {

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
    public void save(ArtistDto dto) {
        artistRepository.save(ArtistMapper.toEntity(dto));
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

    @Override
    public String getAsXml() {
        List<Artist> artists = findAll();
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<artists>");
        for (Artist artist : artists) {
            xmlBuilder.append("<artist>")
                .append("<id>").append(artist.getId()).append("</id>")
                .append("<name>").append(artist.getName()).append("</name>")
                .append("</artist>");
        }
        xmlBuilder.append("</libraries>");
        return xmlBuilder.toString();
    }
}
