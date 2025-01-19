package com.esaee.servlets;

import com.esaee.models.Artist;
import com.esaee.services.ArtistService;
import java.io.IOException;
import java.util.UUID;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("")
public class MainServlet extends HttpServlet {
    @EJB
    private ArtistService artistService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/json");

        try {
            request.setAttribute("artists", artistService.getAllArtist());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            String name = request.getParameter("name");

            Artist artist = new Artist();
            artist.setName(name);
            artist.setId(UUID.randomUUID());
            artistService.createArtist(artist);
        } else if ("delete".equals(action)) {
            UUID id = UUID.fromString(request.getParameter("id"));
            artistService.deleteArtist(id);
        }

        doGet(request, response);
    }
}