<%--
  Created by IntelliJ IDEA.
  User: baptiste
  Date: 19/01/2017
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="Game.GameCheckersImpl" %>
<%@ page import="Helper.GameHelper" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test page web</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
</head>
<body>

<h1>Game Checkers JEE</h1>

<%
    GameCheckersImpl game = GameHelper.getGame(request);
%>

    <script src="${pageContext.request.contextPath}/scripts/angular.js"></script>
    <script src="${pageContext.request.contextPath}/scripts/main.js"></script>
</body>
</html>
