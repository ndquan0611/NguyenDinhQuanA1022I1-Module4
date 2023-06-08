<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/8/2023
  Time: 3:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Convert</title>
</head>
<body>
<div>
    <form action="/convert" method="post">
        <label for="USD">USD: </label>
        <input type="number" id="USD" name="usd" value="${usd}"><br><br>
        <input type="submit" value="Convert">
    </form>
</div>
</body>
</html>
