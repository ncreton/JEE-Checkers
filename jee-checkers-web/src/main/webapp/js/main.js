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

});



