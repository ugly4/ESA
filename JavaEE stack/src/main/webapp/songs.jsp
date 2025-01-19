<%@ page import="com.esaee.models.Album" %>
<%@ page import="com.esaee.models.Song" %>
<%@ page import="java.util.List" %>
<%@ page import="com.esaee.models.Artist" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
    <head>
        <title>Songs</title>
    </head>
    <body>
        <a href="/">Artists</a>
        <a href="/albums">Albums</a>

        <h2>All Songs</h2>

        <% List<Song> songs = (List<Song>) request.getAttribute("songs");%>
        <% List<Album> albums = (List<Album>) request.getAttribute("albums");%>
        <% List<Artist> artists = (List<Artist>) request.getAttribute("artists");%>

        <table>
            <thead>
                <tr>
                    <th>Artist</th>
                    <th>Name</th>
                    <th>Duration</th>
                    <th>Explicit Content</th>
                    <th>Album</th>
                </tr>
            </thead>
            <tbody>
            <% for (Song song : songs) { %>
                <tr>
                    <td><%=song.getName()%></td>
                    <td><%=song.getDuration() / 60%>:<%=song.getDuration() % 60%></td>
                    <td><%=song.getExplicitContent()%></td>
                    <td>
                        <form action="songs" method="post" style="display:inline;">
                            <input type="hidden" name="id" value="<%= song.getId() %>">
                            <input type="hidden" name="action" value="delete">
                            <button type="submit">Delete</button>
                        </form>
                    </td>
                </tr>
            <% } %>
            </tbody>
        </table>

        <h2>Create Song</h2>
        <form action="songs" method="post">
            <input type="text" name="name" placeholder="Name" required>
            <input type="text" name="duration" placeholder="Duration in seconds">
            <label for="explicitContent">Explicit Content</label>
            <input type="checkbox" id="explicitContent" name="explicitContent">
            <select name="artist_id">
                <option disabled selected>Select Artist</option>
                <%
                    for (Artist artist : artists) {
                %>
                <option value="<%= artist.getId() %>"><%= artist.getName() %></option>
                <% } %>
            </select>
            <select name="album_id">
                <option disabled selected>Select Album</option>
                <%
                    for (Album album : albums) {
                %>
                <option value="<%= album.getId() %>"><%= album.getName() %></option>
                <% } %>
            </select>
            <input type="hidden" name="action" value="add">
            <button type="submit">Create Album</button>
        </form>
    </body>
</html>
