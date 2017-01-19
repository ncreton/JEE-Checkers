/**
 * Created by baptiste on 19/01/2017.
 */
var app = angular.module('app', []);

app.controller('mainCtrl', function ($scope) {

    $scope.testArr = [{
        'first': [{
            'value': '0_1',
        },{
            'value': '1_1',
        }, {
            'value': '2_1',
        }, {
            'value': '4_1',
        }, {
            'value': '5_1',
        }, {
            'value': '6_1',
        }, {
            'value': '7_1',
        }, {
            'value': '8_1',
        }, {
            'value': '9_1',
        }, {
            'value': '10_1',
        }]
    }, {
        'second': [{
            'value': '0_2',
        },{
            'value': '1_2',
        }, {
            'value': '2_2',
        }, {
            'value': '3_2',
        }, {
            'value': '4_2',
        }, {
            'value': '5_2',
        }, {
            'value': '6_2',
        }, {
            'value': '7_2',
        }, {
            'value': '8_2',
        }, {
            'value': '9_2',
        }, {
            'value': '10_2',
        }]
    }];

});