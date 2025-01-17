package com.example.LR2_Spring.controllers;

import com.example.LR2_Spring.beans.ArtistServiceBean;
import com.example.LR2_Spring.entities.Album;
import com.example.LR2_Spring.entities.Artist;
import com.example.LR2_Spring.entities.Song;
import com.example.LR2_Spring.beans.AlbumServiceBean;
import com.example.LR2_Spring.beans.SongServiceBean;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/artist")
public class ArtistController {

    private final SongServiceBean songServiceBean;
    private final AlbumServiceBean albumServiceBean;
    private final ArtistServiceBean artistServiceBean;

    @Autowired
    public ArtistController(SongServiceBean songServiceBean, AlbumServiceBean albumServiceBean,
        ArtistServiceBean artistServiceBean) {
        this.songServiceBean = songServiceBean;
        this.albumServiceBean = albumServiceBean;
        this.artistServiceBean = artistServiceBean;
    }

    @GetMapping("{id}")
    public String getContent(Model model, @PathVariable String id) {
        Artist artist = artistServiceBean.findById(UUID.fromString(id));

        model.addAttribute("artist", artist);
        model.addAttribute("albums", albumServiceBean.getAlbumsByArtist(artist));
        model.addAttribute("songs", songServiceBean.getSongsByArtist(artist));
        return "artistContent";
    }

    @PostMapping("/album")
    public String saveAlbum(@ModelAttribute Album album) {
        albumServiceBean.save(album);
        return String.format("redirect:/artist/%s", album.getArtist().getId());
    }

    @PostMapping("/song")
    public String saveSong(@ModelAttribute Song song) {
        songServiceBean.save(song);
        return String.format("redirect:/artist/%s", song.getArtist().getId());
    }
}
