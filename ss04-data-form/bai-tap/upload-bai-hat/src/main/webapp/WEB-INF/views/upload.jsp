<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/16/2023
  Time: 8:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="music" method="post">
    <table>
        <tr>
            <td><form:label path="">Name</form:label></td>
            <td>
                <form:input path="name" />
            </td>
        </tr>
        <tr>
            <td><form:label path="">Artist</form:label></td>
            <td>
                <form:input path="artist" />
            </td>
        </tr>
        <tr>
            <td><form:label path="">Type</form:label></td>
            <td>
                <form:select path="type" items="${type}" />
            </td>
        </tr>
        <tr>
            <td><form:label path="">File</form:label></td>
            <td>
                <form:input type="file" path="file" />
            </td>
        </tr>
    </table>
    <button>Upload</button>
</form:form>
</body>
</html>
