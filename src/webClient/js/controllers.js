/**
 * Created by hieu.vutrong on 1/6/2015.
 */

angular.module('ngClient.controllers', ["ngResource"])


    .controller("CollectBook", function($scope, Book){
        Book.query().then(function( result ) {
            $scope.books = result;
        }, function(error) {
            $scope.errorMess = JSON.stringify(error);
        });


    })