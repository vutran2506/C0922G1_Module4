<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/1/2023
  Time: 2:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<p>${message}</p>
<form action="result" method="post">
  <table>
    <tr>
      <th colspan="2"><input type="number" placeholder="Enter number 1" name="number1"></th>
      <th colspan="2"><input type="number" placeholder="Enter number 2" name="number2"></th>
    </tr>
    <tr>
      <th><input type="submit" name="calculation" value="add(+)"></th>
      <th><input type="submit" name="calculation" value="sub(-)"></th>
      <th><input type="submit" name="calculation" value="multi(*)"></th>
      <th><input type="submit" name="calculation" value="div(/)"></th>
    </tr>
    <tr>
      <th>Result</th>
      <th  colspan="3">${resultName}</th>
    </tr>
  </table>
</form>
</body>
</html>
