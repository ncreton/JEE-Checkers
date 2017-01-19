<%--
  Created by IntelliJ IDEA.
  User: baptiste
  Date: 19/01/2017
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Affichage des données de jeu</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" href="../css/materialize.min.css">
        <link rel="stylesheet" href="../css/main.css">
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    </head>
    <body>
        <p>Player1 : ${ gameConfiguration.player1 }</p>
        <p>Player2 : ${ gameConfiguration.player2 }</p>
        <p>Board lines : ${ gameConfiguration.yCoordinate }</p>
        <p>Board columns : ${ gameConfiguration.xCoordinate }</p>

        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="../js/materialize.min.js"></script>
        <script type="text/javascript" src="../js/angular.min.js"></script>
        <script type="text/javascript" src="../js/main.js"></script>
    </body>
</html>
