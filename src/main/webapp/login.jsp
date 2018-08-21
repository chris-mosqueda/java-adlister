<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%--%>
    <%--if (request.getMethod().equalsIgnoreCase("post")) {--%>
        <%--String username = request.getParameter("username");--%>
        <%--String password = request.getParameter("password");--%>
<%--//        if (username.equals("admin") && password.equals("password")) {--%>
            <%--response.sendRedirect("/profile.jsp");--%>
        <%--//}--%>
    <%--}--%>
<%--%>--%>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Please Log In" />
    </jsp:include>
</head>
<body>
    <jsp:include page="partials/navbar.jsp" />
    <div class="container">
        <h1>Please Log In</h1>
        <form action="/guess" method="POST">
            <div class="form-group">
                <label for="number">Guess the correct number</label>
                <input id="number" name="number" class="form-control" type="number">
            </div>
            <%--  2  <div class="form-group">--%>
                <%--<label for="color">What is your favorite color?</label>--%>
                <%--<input id="color" name="color" class="form-control" type="text">--%>
            <%--</div>--%>

            <%--  1  <div class="form-group">--%>
                <%--<label for="firstname">First Name</label>--%>
                <%--<input id="firstname" name="firstname" class="form-control" type="text">--%>
            <%--</div>--%>

            <%--<div class="form-group">--%>
                <%--<label for="password">Password</label>--%>
                <%--<input id="password" name="password" class="form-control" type="password">--%>
            <%--</div>--%>
            <input type="submit" class="btn btn-primary btn-block" value="Log In">
        </form>
    </div>
</body>
</html>
