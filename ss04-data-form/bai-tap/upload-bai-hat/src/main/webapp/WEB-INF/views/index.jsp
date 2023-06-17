<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/16/2023
  Time: 8:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Artist</th>
        <th>Type</th>
        <th>File</th>
    </tr>
    <tr>
        <td>${music.name}</td>
        <td>${music.artist}</td>
        <td>${music.type}</td>
        <td>${music.file}</td>
    </tr>
</table>
</body>
</html>
