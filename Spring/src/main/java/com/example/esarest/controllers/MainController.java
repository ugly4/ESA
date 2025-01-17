package com.example.esarest.controllers;

import com.example.esarest.entities.Artist;
import com.example.esarest.beans.ArtistServiceBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/artists")
public class MainController {

    private final ArtistServiceBean artistServiceBean;

    public MainController(ArtistServiceBean artistServiceBean) {
        this.artistServiceBean = artistServiceBean;
    }

    @GetMapping
    public String listArtists(Model model) {
        model.addAttribute("artists", artistServiceBean.findAll());
        return "artists";
    }

    @PostMapping
    public String saveArtist(@ModelAttribute Artist artist) {
        artistServiceBean.save(artist);
        return "redirect:/artists";
    }
}
