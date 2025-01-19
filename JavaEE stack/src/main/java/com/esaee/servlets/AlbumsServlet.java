package com.esaee.servlets;

import com.esaee.models.Album;
import com.esaee.services.AlbumService;
import com.esaee.services.ArtistService;
import java.io.IOException;
import java.util.UUID;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/albums")
public class AlbumsServlet extends HttpServlet {
    @EJB
    private AlbumService albumService;
    @EJB
    private ArtistService artistService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/json");

        try {
            request.setAttribute("albums", albumService.getAllAlbums());
            request.setAttribute("artists", artistService.getAllArtist());
            request.getRequestDispatcher("albums.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            Album album = new Album();
            album.setId(UUID.randomUUID());
            album.setLabel(request.getParameter("label"));
            album.setGenre(request.getParameter("genre"));
            album.setYear(Integer.valueOf(request.getParameter("year")));
            album.setArtistId(UUID.fromString(request.getParameter("artist_id")));

            albumService.createAlbum(album);
        } else if ("delete".equals(action)) {
            UUID id = UUID.fromString(request.getParameter("id"));
            albumService.deleteAlbum(id);
        }

        doGet(request, response);
    }
}
