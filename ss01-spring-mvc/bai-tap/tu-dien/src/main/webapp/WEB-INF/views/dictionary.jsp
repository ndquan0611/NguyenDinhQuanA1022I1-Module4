<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/8/2023
  Time: 4:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<div>
    <form action="/dictionary" method="post">
        <label for="english">English: </label>
        <input type="text" id="english" name="english" value="${english}"><br><br>
        <button type="submit">Translate</button>
    </form>
</div>
</body>
</html>
