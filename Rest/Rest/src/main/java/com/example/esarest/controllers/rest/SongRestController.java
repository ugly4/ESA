package com.example.esarest.controllers.rest;

import com.example.esarest.controllers.base.BaseRestController;
import com.example.esarest.dto.SongDto;
import com.example.esarest.entities.Song;
import com.example.esarest.services.SongService;
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
