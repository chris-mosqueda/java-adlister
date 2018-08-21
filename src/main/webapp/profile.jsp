<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body style="background-color:${color}">
    <jsp:include page="partials/navbar.jsp" />

    <div class="container">
        <h1>Correct! ${number}</h1>
        <h2>Random num: ${n}</h2>
    </div>

</body>
</html>
