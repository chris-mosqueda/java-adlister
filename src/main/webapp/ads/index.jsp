<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: christophermosqueda
  Date: 8/22/18
  Time: 8:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View ads</title>
</head>
<body>
    <h1>This is your page of ads....</h1>
    <c:forEach var="viewAd" items="${eachAd}">
        <div class="viewAd">
            <h2>${viewAd.title}</h2>
            <p>Description: ${viewAd.description}</p>
        </div>
    </c:forEach>
</body>
</html>
