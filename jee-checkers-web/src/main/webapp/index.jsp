<%@ page import="Game.GameCheckersImpl" %>
<%@ page import="Helper.GameHelper" %><%--
  Created by IntelliJ IDEA.
  User: Nicolas
  Date: 17/01/2017
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test page web</title>
</head>
<body>

<h1>Game Checkers JEE</h1>

<%
    GameCheckersImpl game = GameHelper.getGame(request);
%>

</body>
</html>
