<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/2/2023
  Time: 9:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Electronic Mailbox</title>
</head>
<body>
<h1>Settings</h1>
<form:form modelAttribute="setting" action="/newUpdate" method="post">
    Language:
    <form:hidden path="id" items="${id}" multiple="false"></form:hidden><br>
    <form:select path="languages" items="${languages}" multiple="false"></form:select><br>
    Page Size:
    <form:select path="pageSize" items="${pageSize}" multiple="false"></form:select>email per page<br>
    Spams Filter:
    <form:checkbox path="spamsFilter"></form:checkbox>Enable spams filter<br>
    Signature:
    <form:textarea path="signature"></form:textarea><br>
    <form:button> Update</form:button>
</form:form>
</body>
</html>
