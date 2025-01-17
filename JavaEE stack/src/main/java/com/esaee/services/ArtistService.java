package com.esaee.services;

import com.esaee.beans.ArtistBean;
import com.esaee.models.Artist;
import java.util.List;
import java.util.UUID;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ArtistService {
    @EJB
    private ArtistBean artistBean;

    public List<Artist> getAllArtist() {
        return artistBean.findAll();
    }

    public void createArtist(Artist artist) {
        artistBean.save(artist);
    }

    public void deleteArtist(UUID id) {
        artistBean.delete(id);
    }
}
