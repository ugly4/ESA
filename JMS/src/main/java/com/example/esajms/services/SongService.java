package com.example.esajms.services;

import com.example.esajms.dto.SongDto;
import com.example.esajms.entities.Artist;
import com.example.esajms.entities.Song;
import com.example.esajms.services.base.BaseService;
import com.example.esajms.services.base.XmlConvertService;
import java.util.List;
import java.util.UUID;

public interface SongService extends BaseService<Song, SongDto, UUID>, XmlConvertService {
    List<Song> getSongsByArtist(Artist artist);
}
