<%--
  Created by IntelliJ IDEA.
  User: christophermosqueda
  Date: 8/20/18
  Time: 12:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    // checks if for was submitted
    if(request.getMethod().equalsIgnoreCase("post")) {
        String uname = request.getParameter("username");
        String pswd = request.getParameter("password");
        String url = "/profile.jsp?user=" + uname;
        //makes sure variables are not null (will get error page without it)
        if(uname != null && pswd != null){
            if(uname.equals("admin") && pswd.equals("password")) {
                response.sendRedirect(url);
            }
        }
    }
%>
<html>
<head>
    <title>Login</title>
    <%@ include file="partials/stylesheets.jsp" %>
</head>
<body>
    <div class="container">
    <%@ include file="partials/navbar.jsp" %>
    <form method="POST" action="/login.jsp">
        <div class="form-group">
            <label for="username">Username *</label>
            <input class="form-control" type="text" id="username" name="username" value="" required>
            <label for="password">Password *</label>
            <input class="form-control" type="text" id="password" name="password" value="" required>
            <input type="submit" value="Submit" name="submit">
        </div>
    </form>

    <%@ include file="partials/footer.jsp" %>
    </div>
</body>
</html>
