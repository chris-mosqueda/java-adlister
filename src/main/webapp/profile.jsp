<%--
  Created by IntelliJ IDEA.
  User: christophermosqueda
  Date: 8/20/18
  Time: 12:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1><%= request.getParameter("user") %> page</h1>
    <form method="POST" action="/login.jsp">
        <input type="submit" value="Logout" name="submit">
    </form>
    <p></p>
</body>
</html>
