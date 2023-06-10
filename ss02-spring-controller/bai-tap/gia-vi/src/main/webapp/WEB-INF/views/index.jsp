<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/10/2023
  Time: 2:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich</title>
</head>
<body>
<div>
    <h1>Sandwich Condiments</h1>
    <form action="/save" method="post">
        <input type="checkbox" id="vehicle1" name="condiment" value="Lettuce">
        <label for="vehicle1"> Lettuce</label>
        <input type="checkbox" id="vehicle2" name="condiment" value="Tomato">
        <label for="vehicle2"> Tomato</label>
        <input type="checkbox" id="vehicle3" name="condiment" value="Mustard">
        <label for="vehicle4"> Mustard</label>
        <input type="checkbox" id="vehicle4" name="condiment" value="Sprouts">
        <label for="vehicle3"> Sprouts</label>
        <hr/>
        <button>Submit</button>
    </form>
</div>
</body>
</html>
