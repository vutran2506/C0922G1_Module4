<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/1/2023
  Time: 10:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Check Email</title>
</head>
<body>
<h1> Check Email</h1>
<p>${message}</p>
<form action="validate" method="post">
  <table>
    <tr>
      <th>Input Email Check</th>
      <th><input type="text" name="email"></th>
    </tr>
    <tr>
      <th></th>
      <th><button type="submit"> Check</button></th>
    </tr>
    <tr>
      <th> Result</th>
      <th>${email}</th>
    </tr>
  </table>
</form>
</body>
</html>
