<%--
  Created by IntelliJ IDEA.
  User: christophermosqueda
  Date: 8/20/18
  Time: 3:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Template</title>
    <%@ include file="partials/stylesheets.jsp" %>
</head>
<body>
    <%@ include file="partials/navbar.jsp" %>
    <p>Template page stuff</p>
    <form method="POST" action="/login.jsp">
        <input type="submit" value="Login Page" name="submit">
    </form>
    <%@ include file="partials/footer.jsp" %>
</body>
</html>
