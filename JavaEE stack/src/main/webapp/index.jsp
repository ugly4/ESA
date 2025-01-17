<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.esaee.models.Artist" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <title>JAVA music</title>
</head>
<body>
<% List<Artist> artists = (List<Artist>) request.getAttribute("artists");%>

<h2>Create Artist</h2>
<form action="artists" method="post">
    <input type="text" name="name" placeholder="Artist Name" required>
    <input type="hidden" name="action" value="add">
    <button type="submit">Create Artist</button>
</form>

<table>
    <thead>
    <tr>
        <th>Name</th>
    </tr>
    </thead>
    <tbody>
    <% for (Artist artist : artists) { %>
    <tr>
        <td><a href="artist/<%=artist.getName()%>"><%= artist.getName() %></a>
    </tr>
    <% } %>
    </tbody>
</table>
</body>
</html>