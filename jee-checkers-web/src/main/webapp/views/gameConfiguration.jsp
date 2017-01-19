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
        <h1 class="center-align">Game Checkers</h1>

        <div class="row">
            <form class="col s12 m4 offset-m4" <%--method="post" action="GameHelper"--%> ng-submit="postConfToServer()">
                <label for="Player1">Player1</label>
                <input type="text" id="Player1" name="Player1" value="" maxlength="20" data-ng-model="Player1" />
                <br />

                <label for="Player2">Player2</label>
                <input type="text" id="Player2" name="Player2" value="" maxlength="20" data-ng-model="Player2"/>
                <br />

                <label for="yCoordinate">Board lines</label>
                <input type="number" id="yCoordinate" name="yCoordinate" value="10" min="10" step="1" data-ng-model="yCoordinate"/>
                <br />

                <label for="xCoordinate">Board columns</label>
                <input type="number" id="xCoordinate" name="xCoordinate" value="10" min="10" step="1" data-ng-model="xCoordinate"/>

                <button class="btn waves-effect waves-light col s12 m6 offset-m3" type="submit" name="action">Play
                    <i class="material-icons right">send</i>
                </button>
            </form>
        </div>

        <div class="row">
            <p>Board cols : {{ board.nbCols}}</p>
            <p>Board rows : {{ board.nbRows}}</p>
            <p>Current player : {{ board.currentPlayer.name }}</p>
        </div>

        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <script type="text/javascript" src="js/angular.min.js"></script>
        <script type="text/javascript" src="js/main.js"></script>

        <script>
            var app = angular.module('AppChecker', []);

            app.controller('confController', function($scope, $http){
                $scope.postConfToServer = function() {
                    $http({
                        method : 'POST',
                        url : 'GameHelper',
                        data : {
                            Player1 : $scope.Player1,
                            Player2 : $scope.Player2,
                            xCoordinate : $scope.xCoordinate,
                            yCoordinate : $scope.yCoordinate
                        },
                        headers: {
                            'Content-Type': 'application/json'
                        }
                    }).then(function(success) {
                        //$scope.person = data;
                        console.log(success);
                        $scope.board = success.data.board;
                    }),function(error) {
                        console.log(error);
                    };

                };
            });
        </script>

    </body>
</html>
