<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="partials/navbar.jsp" />

    <div class="container">
        <h1>Viewing your profile - ${user}</h1>
    </div>

    <form method="POST" action="/singleView">
        <input type="submit" value="1 ad" name="submit">
    </form>

</body>
</html>
