<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/10/2023
  Time: 2:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Show</title>
</head>
<body>
<div>
    <h3>${msg}</h3>
    <c:forEach items="${list}" var="l">
        <p>${l}</p>
    </c:forEach>
</div>
</body>
</html>
