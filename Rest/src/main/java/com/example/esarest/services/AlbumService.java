package com.example.esarest.services;

import com.example.esarest.dto.AlbumDto;
import com.example.esarest.entities.Album;
import com.example.esarest.entities.Artist;
import com.example.esarest.services.base.BaseService;
import com.example.esarest.services.base.XmlConvertService;
import java.util.List;
import java.util.UUID;

public interface AlbumService extends BaseService<Album, AlbumDto, UUID>, XmlConvertService {
    List<Album> getAlbumsByArtist(Artist artist);

}
