package com.example.esarest.controllers.rest;

import com.example.esarest.beans.ArtistServiceBean;
import com.example.esarest.controllers.base.BaseRestController;
import com.example.esarest.dto.ArtistDto;
import com.example.esarest.entities.Artist;
import java.util.UUID;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/artists")
public class ArtistRestController extends BaseRestController<Artist, ArtistDto, UUID> {

    public ArtistRestController(ArtistServiceBean artistService) {
        super(artistService);
    }
}
