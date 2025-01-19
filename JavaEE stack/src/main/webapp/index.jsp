<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.esaee.models.Artist" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
    <head>
        <title>JAVA music</title>
    </head>

    <body>
        <h1>JAVA Music</h1>
        <a href="/albums">Albums</a>
        <a href="/songs">Songs</a>
        <% List<Artist> artists = (List<Artist>) request.getAttribute("artists");%>

        <table>
            <thead>
                <tr>
                    <th>Name</th>
                    <th></th>
                </tr>
            </thead>

            <tbody>
            <% for (Artist artist : artists) { %>
                <tr>
                    <td><%= artist.getName() %> </td>
                    <td>
                        <form action="" method="post" style="display:inline;">
                            <input type="hidden" name="id" value="<%= artist.getId() %>">
                            <input type="hidden" name="action" value="delete">
                            <button type="submit">Delete</button>
                        </form>
                    </td>
                </tr>
            <% } %>
            </tbody>
        </table>

        <h2>Create Artist</h2>
        <form action="" method="post">
            <input type="text" name="name" placeholder="Artist Name" required>
            <input type="hidden" name="action" value="add">
            <button type="submit">Create Artist</button>
        </form>
    </body>
</html>