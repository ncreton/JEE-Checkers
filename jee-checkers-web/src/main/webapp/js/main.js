/**
 * Created by baptiste on 19/01/2017.
 */
var app = angular.module('AppChecker', []);

app.controller('mainCtrl', function ($scope) {

    $scope.range = function(min, max, step) {
        step = step || 1;
        var input = [];
        for (var i = min; i <= max; i += step) {
            input.push(i);
        }
        return input;
    };
});

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

    $scope.resetGame = function() {
        delete $scope.Player1;
        delete $scope.Player2;
        delete $scope.xCoordinate;
        delete $scope.yCoordinate;
        delete $scope.board;
    };

    $scope.setCellColor = function(rowIndex, colIndex) {
        if(colIndex %2 == 0 && rowIndex %2 == 0){
            return {"backgroundColor": "black"};
        }
        if(colIndex %2 == 0 && rowIndex %2 == 1){
            return {"backgroundColor": "white"};
        }

        if(colIndex %2 == 1 && rowIndex %2 == 0){
            return {"backgroundColor": "white"};
        }

        if(colIndex %2 == 1 && rowIndex %2 == 1){
            return {"backgroundColor": "black"};
        }
    };

    //TODO: Pawns for queens
    $scope.setStyling = function(rowIndex, colIndex) {
        var cell = $scope.board.cells[rowIndex][colIndex];
        console.log(cell.pawn);
        if(cell.pawn != undefined){
            if(cell.pawn.pawnColor == "WHITE" && cell.pawn.pawnType == "NORMAL"){
                return {"backgroundColor": "#81c784"};
            }
            if(cell.pawn.pawnColor == "BLACK" && cell.pawn.pawnType == "NORMAL"){
                return {"backgroundColor": "#ff8a65"};
            }
        }
        else {
            return {"backgroundColor": "none"};
        }
    }

    $scope.play = function(rowIndex, colIndex) {
        console.log("row" + rowIndex);
        console.log("col" + colIndex);
    };

});



