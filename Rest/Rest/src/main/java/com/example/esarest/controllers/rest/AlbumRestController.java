package com.example.esarest.controllers.rest;

import com.example.esarest.controllers.base.BaseRestController;
import com.example.esarest.dto.AlbumDto;
import com.example.esarest.entities.Album;
import com.example.esarest.services.AlbumService;
import java.util.UUID;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/albums")
public class AlbumRestController extends BaseRestController<Album, AlbumDto, UUID> {
    public AlbumRestController(AlbumService albumService) {
        super(albumService);
    }
}
