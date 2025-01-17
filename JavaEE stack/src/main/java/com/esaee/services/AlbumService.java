package com.esaee.services;

import com.esaee.beans.AlbumBean;
import com.esaee.models.Album;
import java.util.List;
import java.util.UUID;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AlbumService {
    @EJB
    private AlbumBean albumBean;

    public List<Album> getAllAlbums() {
        return albumBean.findAll();
    }

    public void createAlbum(Album album) {
        albumBean.save(album);
    }

    public void deleteAlbum(UUID id) {
        albumBean.delete(id);
    }

    public List<Album> getAlbumsByArtist(UUID artistId) {
        return albumBean.findAlbumsByArtist(artistId);
    }
}
