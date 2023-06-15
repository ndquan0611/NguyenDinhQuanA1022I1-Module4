<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/14/2023
  Time: 8:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <form:form modelAttribute="email" method="post" action="update">
        <table>
            <tr>
                <td colspan="2"><form:label path="languages"><b>Languages: </b></form:label></td>
                <td colspan="4">
                    <form:select path="languages" items="${languages}"/>
                </td>
            </tr>
            <tr>
                <td colspan="2"><form:label path="size"><b>Page Size: </b></form:label></td>
                <td colspan="4">
                    <span>Show</span>
                    <form:select path="size" items="${size}"/>
                    <span>emails per page</span>
                </td>
            </tr>
            <tr>
                <td colspan="2"><form:label path="filter"><b>Spams filter: </b></form:label></td>
                <td colspan="4">
                    <form:checkbox path="filter" value="true"/>
                    <span>Enable spams filter</span>
                </td>
            </tr>
            <tr>
                <td colspan="2"><form:label path="signature"><b>Signature: </b></form:label></td>
                <td colspan="4">
                        <form:textarea path="signature"/>
            </tr>
            <tr>
                <td colspan="2"></td>
                <td colspan="4">
                    <button type="submit">Update</button>
                    <button type="reset">Cancel</button>
                </td>
            </tr>
        </table>
    </form:form>
</body>
</html>
