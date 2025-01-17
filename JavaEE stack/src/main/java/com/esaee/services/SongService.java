package com.esaee.services;

import com.esaee.beans.SongBean;
import com.esaee.models.Song;
import java.util.List;
import java.util.UUID;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class SongService {
    @EJB
    private SongBean songBean;

    public List<Song> getAllSongs() {
        return songBean.findAll();
    }

    public void createSong(Song song) {
        songBean.save(song);
    }

    public void deleteSong(UUID id) {
        songBean.delete(id);
    }

    public List<Song> getSongsByArtist(UUID artistId) {
        return songBean.findSongsByArtist(artistId);
    }
}
