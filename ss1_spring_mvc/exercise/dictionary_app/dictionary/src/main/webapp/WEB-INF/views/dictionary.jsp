<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/31/2023
  Time: 6:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<h1>DICTIONARY</h1>
<form action="translate" method="post">
    <table>
        <tr>
            <th>Input Vocabulary</th>
            <th><input type="text" name="vocabulary" placeholder="Enter Vocabulary"></th>
        </tr>
        <tr>
            <th></th>
            <th><button type="submit">Translate</button></th>
        </tr>
        <tr>
            <th>Result</th>
            <th>${vietnamese}</th>
        </tr>
    </table>
</form>
</body>
</html>
