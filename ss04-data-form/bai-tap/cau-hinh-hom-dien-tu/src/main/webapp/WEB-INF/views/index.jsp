<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/14/2023
  Time: 9:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<table>
    <tr>
        <td>Languages:</td>
        <td>${email.languages}</td>
    </tr>
    <tr>
        <td>Page Size:</td>
        <td>${email.size}</td>
    </tr>
    <tr>
        <td>Spams filter:</td>
        <td>${email.filter}</td>
    </tr>
    <tr>
        <td>Signature:</td>
        <td>${email.signature}</td>
    </tr>
</table>
</body>
</html>
