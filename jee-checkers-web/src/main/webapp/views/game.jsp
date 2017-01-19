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
        <title>Checkers</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" href="../css/materialize.min.css">
        <link rel="stylesheet" href="../css/main.css">
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    </head>
    <body>
        <p>Current player : ${ gameConfiguration.board.getCurrentPlayer().getName() }</p>

        <p>Player1 : ${ gameConfiguration.board.getPlayerWhite().getName() }</p>
        <p>Pawns's Player1 : ${ gameConfiguration.getBoard().getPlayerWhite().getNbPawns() }</p>


        <p>Player2 : ${ gameConfiguration.board.getPlayerBlack().getName() }</p>
        <p>Pawns's Player2 : ${ gameConfiguration.getBoard().getPlayerBlack().getNbPawns() }</p>

        <p>Board lines : ${ gameConfiguration.board.getNbRows() }</p>
        <p>Board columns : ${ gameConfiguration.board.getNbCols() }</p>



        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="../js/materialize.min.js"></script>
        <script type="text/javascript" src="../js/angular.min.js"></script>
        <script type="text/javascript" src="../js/main.js"></script>
    </body>
</html>
