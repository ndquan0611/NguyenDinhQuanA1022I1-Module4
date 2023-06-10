<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/10/2023
  Time: 2:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<div>
    <form action="/calculator" method="post">
        <h1>Calculator</h1>
        <div>
            <input type="text" value="${input1}" name="inputE1" />
            <input type="text" value="${input2}" name="inputE2" />
        </div>
        <div style="margin-top: 10px">
            <input type="submit" name="calculator" value="Addition(+)">
            <input type="submit" name="calculator" value="Subtraction(-)">
            <input type="submit" name="calculator" value="Multiplication(X)">
            <input type="submit" name="calculator" value="Division(/)">
        </div>
    </form>
    <p class="result">Result Division: ${result}<span></span></p>
</div>
</body>
</html>
