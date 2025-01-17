package com.esaee.servlets;

import com.esaee.models.Album;
import com.esaee.models.Song;
import com.esaee.services.AlbumService;
import com.esaee.services.SongService;
import java.io.IOException;
import java.util.UUID;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "", value = "")
public class ArtistServlet extends HttpServlet {
    @EJB
    private AlbumService albumService;
    @EJB
    private SongService songService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/json");

        try {
            request.setAttribute("albums", albumService.getAlbumsByArtist(UUID.fromString("id")));
            request.setAttribute("songs", songService.getSongsByArtist(UUID.fromString("id")));
            request.getRequestDispatcher("artist.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("addAlbum".equals(action)) {
            Album album = new Album();
            album.setLabel(request.getParameter("label"));
            album.setGenre(request.getParameter("genre"));
            album.setYear(Integer.valueOf(request.getParameter("year")));
            album.setArtistId(UUID.fromString(request.getParameter("artist_id")));

            albumService.createAlbum(album);
        } else if ("addSong".equals(action)) {
            Song song = new Song();
            song.setName(request.getParameter("name"));
            song.setArtistId(UUID.fromString(request.getParameter("artist_id")));
            song.setDuration(Long.valueOf(request.getParameter("Duration")));
            song.setExplicitContent(Boolean.valueOf(request.getParameter("explicitContent")));
            song.setAlbumId(UUID.fromString(request.getParameter("album_id")));

            songService.createSong(song);
        }

        doGet(request, response);
    }
}
