/**
 * Created by baptiste on 19/01/2017.
 */
var app = angular.module('app', []);

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

