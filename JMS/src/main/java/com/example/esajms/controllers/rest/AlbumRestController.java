package com.example.esajms.controllers.rest;

import com.example.esajms.controllers.base.BaseRestController;
import com.example.esajms.dto.AlbumDto;
import com.example.esajms.entities.Album;
import com.example.esajms.services.AlbumService;
import java.util.UUID;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/albums")
public class AlbumRestController extends BaseRestController<Album, AlbumDto, UUID> {
    public AlbumRestController(AlbumService albumService) {
        super(albumService);
    }
}
