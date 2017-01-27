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
        <title>Game Checkers</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" href="css/materialize.min.css">
        <link rel="stylesheet" href="css/main.css">
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    </head>

    <body ng-app="AppChecker" ng-controller="confController">
        <h1 class="center-align" ng-show="board == undefined">Game Checkers</h1>

        <h5 class="center-align marginTop" ng-show="board == undefined">New game</h5>
        <div class="row" ng-show="board == undefined">
            <form class="col s12 m4 offset-m4" <%--method="post" action="GameHelper"--%>ng-init = "postResumeGame()" ng-submit="postConfToServer()">
                <label for="Player1">Player1</label>
                <input type="text" id="Player1" name="Player1" value="" maxlength="20" data-ng-model="Player1" />
                <br />

                <label for="Player2">Player2</label>
                <input type="text" id="Player2" name="Player2" value="" maxlength="20" data-ng-model="Player2"/>
                <br />

                <button class="btn green waves-effect waves-light col s12 m6 offset-m3" type="submit" name="action">Play
                    <i class="material-icons right">play_arrow</i>
                </button>
            </form>
        </div>
        <div class="divider" ng-show="board == undefined"></div>

        <h5 class="center-align marginTop" ng-show="board == undefined">Continue my game</h5>
        <div class="row" ng-show="board == undefined">
            <form class="col s12 m4 offset-m4">
                <label for="token">Token</label>
                <input type="text" id="token" name="token" value="" maxlength="20" data-ng-model="token" />
                <br />

                <button class="btn orange lighten-1 waves-effect waves-light col s12 m6 offset-m3" type="submit" name="action">Continue
                    <i class="material-icons right">hourglass_empty</i>
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
            <span><button class="btn waves-effect waves-light" ng-click="resetGame()">Exit</button></span>
            <span><button class="btn waves-effect waves-light" ng-click="postResetGame()">Reset</button></span>
        </div>

        <div id="gameContainer" class="row center-align" ng-show="board != undefined">
            <div ng-controller="mainCtrl" class="removeSpace">
                <div ng-init="rowIndex = $index" ng-repeat="row in range(0,board.nbRows - 1)" style="width:100%">
                    <div ng-repeat="col in range(0,board.nbCols - 1)" class="gameCell" ng-style="setCellColor(rowIndex,$index)" ng-click="play(rowIndex,$index)">
                        <div ng-style="setStyling(rowIndex,$index)" class="circle">
                            <span></span>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal Structure -->
        <div id="modal1" class="modal">
            <div class="modal-content">
                <h4>Game finished</h4>
                <p>{{winner}} has won!</p>
            </div>
            <div class="modal-footer">
                <a href="#!" class=" modal-action modal-close waves-effect waves-green btn-flat">Close</a>
            </div>
        </div>


        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <script type="text/javascript" src="js/angular.min.js"></script>
        <script type="text/javascript" src="js/main.js"></script>
    </body>
</html>
