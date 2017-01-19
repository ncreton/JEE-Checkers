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
        <link rel="stylesheet" href="css/materialize.min.css">
        <link rel="stylesheet" href="css/main.css">
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    </head>
    <body>
        <div class="row">
            <div class="col s12 m4">
                <div class="card green lighten-2">
                    <div class="card-content white-text">
                        <span class="card-title">${ gameConfiguration.board.getPlayerWhite().getName() }</span>
                        <p>Pawns: ${ gameConfiguration.getBoard().getPlayerWhite().getNbPawns() }</p>
                    </div>
                </div>
            </div>

            <div class="col s12 m4">
                <div class="card white">
                    <div class="card-content center-align">
                        <span class="card-title">Current player</span>
                        <p>${ gameConfiguration.board.getCurrentPlayer().getName() }</p>
                    </div>
                </div>
            </div>

            <div class="col s12 m4">
                <div class="card deep-orange lighten-2">
                    <div class="card-content white-text right-align">
                        <span class="card-title">${ gameConfiguration.board.getPlayerBlack().getName() }</span>
                        <p>Pawns: ${ gameConfiguration.getBoard().getPlayerBlack().getNbPawns() }</p>
                    </div>
                </div>
            </div>
        </div>


        <p>Board size : ${ gameConfiguration.board.getNbRows() } x ${ gameConfiguration.board.getNbCols() }</p>

        <div ng-app="app" class="center-align">
            <div ng-controller="mainCtrl">
                <div ng-repeat="n in range(1,10)" class="removeSpace">
                    <div ng-repeat="n in range(1,10)" class="gameCell"></div>
                </div>
            </div>
        </div>


        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <script type="text/javascript" src="js/angular.min.js"></script>
        <script type="text/javascript" src="js/main.js"></script>
    </body>
</html>
