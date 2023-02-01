<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/1/2023
  Time: 11:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich Condiments</title>
</head>
<body>
<h1> Sandwich Condiments</h1>
<form action="save" method="post">
  <span><input type="checkbox" value="Lettuce" name="condiment">Lettuce</span>
  <span><input type="checkbox" value="Tomato" name="condiment" >Tomato</span>
  <span><input type="checkbox" value="Mustard" name="condiment">Mustard</span>
  <span><input type="checkbox" value="Sprouts" name="condiment">Sprouts</span><br>
  <button type="submit">Save</button>
</form>
<table>
  <tr>
    <th>Sandwich Condiments</th>
  </tr>
  <c:forEach var="condiment" items="${condimentList}">
    <tr>
      <th>${condiment}</th>
    </tr>
  </c:forEach>
</table>
</body>
</html>
