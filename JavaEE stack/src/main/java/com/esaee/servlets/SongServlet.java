package com.esaee.servlets;

import com.esaee.models.Song;
import com.esaee.services.AlbumService;
import com.esaee.services.ArtistService;
import com.esaee.services.SongService;
import java.io.IOException;
import java.util.UUID;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/songs")
public class SongServlet extends HttpServlet {
    @EJB
    private AlbumService albumService;
    @EJB
    private ArtistService artistService;
    @EJB
    private SongService songService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/json");

        try {
            request.setAttribute("songs", songService.getAllSongs());
            request.setAttribute("albums", albumService.getAllAlbums());
            request.setAttribute("artists", artistService.getAllArtist());
            request.getRequestDispatcher("songs.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            Song song = new Song();
            song.setId(UUID.randomUUID());
            song.setName(request.getParameter("name"));
            song.setDuration(Long.valueOf(request.getParameter("duration")));
            song.setExplicitContent(Boolean.valueOf(request.getParameter("explicitContent")));
            song.setAlbumId(UUID.fromString(request.getParameter("album_id")));
            song.setArtistId(UUID.fromString(request.getParameter("artist_id")));

            songService.createSong(song);
        } else if ("delete".equals(action)) {
            UUID id = UUID.fromString(request.getParameter("id"));
            songService.deleteSong(id);
        }

        doGet(request, response);
    }
}
