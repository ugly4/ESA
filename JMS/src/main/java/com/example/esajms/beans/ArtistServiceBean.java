package com.example.esajms.beans;

import com.example.esajms.audit.service.AuditService;
import com.example.esajms.dto.ArtistDto;
import com.example.esajms.entities.Artist;
import com.example.esajms.mappers.ArtistMapper;
import com.example.esajms.repositories.ArtistRepository;
import com.example.esajms.services.base.BaseService;
import com.example.esajms.services.base.XmlConvertService;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceBean implements BaseService<Artist, ArtistDto, UUID>, XmlConvertService {

    private final ArtistRepository artistRepository;
    private final AuditService auditService;

    @Autowired
    public ArtistServiceBean(ArtistRepository libraryRepository, AuditService auditService) {
        this.artistRepository = libraryRepository;
        this.auditService = auditService;
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
        Artist artist = artistRepository.save(ArtistMapper.toEntity(dto));
        auditService.insertAuditEvent(artist);
    }

    @Override
    public void delete(UUID id) {
        Artist artist = artistRepository.findById(id).orElseThrow(
                () -> new RuntimeException("No artist found with id: " + id)
        );
        artistRepository.deleteById(id);
        auditService.deleteAuditEvent(artist);
    }

    @Override
    public void update(Artist entity) {
        artistRepository.findById(entity.getId()).orElseThrow(
                () -> new RuntimeException("No artist found with id: " + entity.getId())
        );
        Artist artist = artistRepository.save(entity);
        auditService.updateAuditEvent(artist);
    }

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
        xmlBuilder.append("</artists>");
        return xmlBuilder.toString();
    }
}
