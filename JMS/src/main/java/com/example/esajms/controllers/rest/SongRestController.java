package com.example.esajms.controllers.rest;

import com.example.esajms.controllers.base.BaseRestController;
import com.example.esajms.dto.SongDto;
import com.example.esajms.entities.Song;
import com.example.esajms.services.SongService;
import java.util.UUID;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/songs")
public class SongRestController extends BaseRestController<Song, SongDto, UUID> {

    public SongRestController(SongService songService) {
        super(songService);
    }
}
