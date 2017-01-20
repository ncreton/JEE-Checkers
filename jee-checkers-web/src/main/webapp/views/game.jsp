<%--
  Created by IntelliJ IDEA.
  User: baptiste
  Date: 19/01/2017
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Game Checkers Configuration</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" href="css/materialize.min.css">
        <link rel="stylesheet" href="css/main.css">
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    </head>

    <body ng-app="AppChecker" ng-controller="confController">
        <h1 class="center-align" ng-show="board == undefined">Game Checkers</h1>

        <div class="row" ng-show="board == undefined">
            <form class="col s12 m4 offset-m4" <%--method="post" action="GameHelper"--%> ng-submit="postConfToServer()">
                <label for="Player1">Player1</label>
                <input type="text" id="Player1" name="Player1" value="" maxlength="20" data-ng-model="Player1" />
                <br />

                <label for="Player2">Player2</label>
                <input type="text" id="Player2" name="Player2" value="" maxlength="20" data-ng-model="Player2"/>
                <br />

                <label for="yCoordinate">Board lines</label>
                <input type="number" id="yCoordinate" name="yCoordinate" value="" min="10" step="1" data-ng-model="yCoordinate"/>
                <br />

                <label for="xCoordinate">Board columns</label>
                <input type="number" id="xCoordinate" name="xCoordinate" value="" min="10" step="1" data-ng-model="xCoordinate"/>

                <button class="btn waves-effect waves-light col s12 m6 offset-m3" type="submit" name="action">Play
                    <i class="material-icons right">send</i>
                </button>
            </form>
        </div>

        <div class="row" ng-show="board != undefined">
            <div class="col s12 m4">
                <div class="card green lighten-2">
                    <div class="card-content white-text">
                        <span class="card-title">{{board.playerWhite.name}}</span>
                        <p>Pawns: {{board.playerWhite.nbPawns}}</p>
                    </div>
                </div>
            </div>

            <div class="col s12 m4">
                <div class="card white">
                    <div class="card-content center-align">
                        <span class="card-title">Current player</span>
                        <p>{{board.currentPlayer.name}}</p>
                    </div>
                </div>
            </div>

            <div class="col s12 m4">
                <div class="card deep-orange lighten-2">
                    <div class="card-content white-text right-align">
                        <span class="card-title">{{board.playerBlack.name}}</span>
                        <p>Pawns: {{board.playerBlack.nbPawns}}</p>
                    </div>
                </div>
            </div>
        </div>

        <div class="row center-align" ng-show="board != undefined">
            <p>Board cols : {{ board.nbCols}} | Board rows : {{ board.nbRows}} | Current player : {{ board.currentPlayer.name }}</p>
            <span><button class="btn waves-effect waves-light" ng-click="resetGame()">Reset</button></span>
        </div>

        <div class="center-align" ng-show="board != undefined">
            <div ng-controller="mainCtrl" class="removeSpace">
                <div ng-repeat="n in range(1,10)">
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
