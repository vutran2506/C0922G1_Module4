<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/2/2023
  Time: 2:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Setting</title>
</head>
<body>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Languages</th>
            <th> Page Size</th>
            <th> Spams filter</th>
            <th>Signature</th>
            <th></th>
        </tr>
        <c:forEach var="list" items="${listSetting}">
            <tr>
                <td>${list.id}</td>
                <td>${list.getLanguages()}</td>
                <td>${list. getPageSize()}</td>
                <td>${list.getSpamsFilter()}</td>
                <td>${list.getSignature() }</td>
                <td><a href="/update/${list.id}">Update</a></td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
