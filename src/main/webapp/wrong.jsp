<%--
  Created by IntelliJ IDEA.
  User: christophermosqueda
  Date: 8/21/18
  Time: 12:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Guess again</title>
    <h2>${userNum} is incorrect</h2>
    <h1>${again}</h1>
    <p>try ${n}</p>
    <form method="POST" action="/login.jsp">
        <input type="submit" value="Login Page" name="submit">
    </form>

</head>
<body>

</body>
</html>
