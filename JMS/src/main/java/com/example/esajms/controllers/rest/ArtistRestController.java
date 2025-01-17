package com.example.esajms.controllers.rest;

import com.example.esajms.beans.ArtistServiceBean;
import com.example.esajms.controllers.base.BaseRestController;
import com.example.esajms.dto.ArtistDto;
import com.example.esajms.entities.Artist;
import java.util.UUID;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/artists")
public class ArtistRestController extends BaseRestController<Artist, ArtistDto, UUID> {

    public ArtistRestController(ArtistServiceBean artistService) {
        super(artistService);
    }
}
