<%@ page import="com.esaee.models.Album" %>
<%@ page import="java.util.List" %>
<%@ page import="com.esaee.models.Artist" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
    <head>
        <title>Albums</title>
    </head>
    <body>
        <a href="/">Artists</a>
        <a href="/songs">Songs</a>

        <h2>All Albums</h2>
        <% List<Album> albums = (List<Album>) request.getAttribute("albums");%>
        <% List<Artist> artists = (List<Artist>) request.getAttribute("artists");%>

        <table>
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Year</th>
                    <th>Genre</th>
                    <th>Label</th>
                </tr>
            </thead>

            <tbody>
            <% for (Album album : albums) { %>
                <tr>
                    <td><%= album.getName()%></td>
                    <td><%=album.getYear()%></td>
                    <td><%=album.getGenre()%></td>
                    <td><%=album.getLabel()%></td>
                    <td>
                        <form action="albums" method="post" style="display:inline;">
                            <input type="hidden" name="id" value="<%= album.getId() %>">
                            <input type="hidden" name="action" value="delete">
                            <button type="submit">Delete</button>
                        </form>
                    </td>
                </tr>
            <% } %>
            </tbody>
        </table>

        <h2>Create Album</h2>
        <form action="albums" method="post">
            <input type="text" name="name" placeholder="Name" required>
            <input type="text" name="year" placeholder="Year">
            <input type="text" name="genre" placeholder="Genre">
            <input type="text" name="label" placeholder="Label">
            <select name="artist_id">
                <option disabled selected>Select Artist</option>
                <%
                    for (Artist artist : artists) {
                %>
                <option value="<%= artist.getId() %>"><%= artist.getName() %></option>
                <% } %>
            </select>
            <input type="hidden" name="action" value="add">
            <button type="submit">Create Album</button>
        </form>
    </body>
</html>
