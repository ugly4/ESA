<%@ page import="com.esaee.models.Album" %>
<%@ page import="com.esaee.models.Song" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Profile <%= request.getAttribute("artist") %></title>
</head>
<body>
<h2>Create Album</h2>
<form action="albums" method="post">
    <input type="text" name="name" placeholder="Name" required>
    <input type="text" name="year" placeholder="Year">
    <input type="text" name="genre" placeholder="Genre">
    <input type="text" name="label" placeholder="Label">
    <input type="hidden" name="artist_id" value=<%= request.getAttribute("artist")%>>
    <input type="hidden" name="action" value="addAlbum">
    <button type="submit">Create Album</button>
</form>
<h2>All Albums</h2>
<% List<Album> albums = (List<Album>) request.getAttribute("albums");%>
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
        <td><a href="album/<%=album.getName()%>"><%= album.getName() %></a>
        <td><%=album.getYear()%> </td>
        <td><%=album.getGenre()%></td>
        <td><%=album.getLabel()%></td>
    </tr>
    <% } %>
    </tbody>
</table>

<h2>All Songs</h2>
<% List<Song> songs = (List<Song>) request.getAttribute("songs");%>
<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Duration</th>
        <th>Explicit Content</th>
    </tr>
    </thead>
    <tbody>
    <% for (Song song : songs) { %>
    <tr>
        <td><%=song.getName()%></td>
        <td><%=song.getDuration() / 60  + song.getDuration() % 60%></td>
        <td><%=song.getExplicitContent()%></td>
    </tr>
    <% } %>
    </tbody>
</table>
<h2>Create Song</h2>
<form action="songs" method="post">
    <input type="text" name="name" placeholder="Name" required>
    <input type="text" name="duration" placeholder="Duration in seconds">
    <input type="checkbox" name="explicitContent">
    <input type="hidden" name="artist_id" value=<%= request.getAttribute("artist")%>>
    <select name="album_id">
        <option disabled selected>Select Album</option>
        <%
            for (Album album : albums) {
        %>
        <option value="<%= album.getId() %>"><%= album.getName() %></option>
        <% } %>
    </select>
    <input type="hidden" name="action" value="addSong">
    <button type="submit">Create Album</button>
</form>
</body>
</html>
