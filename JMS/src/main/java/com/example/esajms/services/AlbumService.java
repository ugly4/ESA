package com.example.esajms.services;

import com.example.esajms.dto.AlbumDto;
import com.example.esajms.entities.Album;
import com.example.esajms.entities.Artist;
import com.example.esajms.services.base.BaseService;
import com.example.esajms.services.base.XmlConvertService;
import java.util.List;
import java.util.UUID;

public interface AlbumService extends BaseService<Album, AlbumDto, UUID>, XmlConvertService {
    List<Album> getAlbumsByArtist(Artist artist);
}
