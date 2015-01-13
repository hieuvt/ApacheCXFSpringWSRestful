/**
 * Created by hieu.vutrong on 1/6/2015.
 */

angular.module('ngClient.controllers', ["ngResource"])

    .controller("BookCtrl", function ($scope, Books, Book, $location, $window) {
        Books.query().then(function (result) {
            $scope.books = result;
        }, function (error) {
            $scope.errorMess = JSON.stringify(error);
        });

        $scope.editBook = function (bookId) {
            $location.path('/book-detail/' + bookId);
        }

        $scope.deleteBook = function (bookId) {
            Book.delete(bookId).then(function (result) {
                $scope.books = result;
            }, function (error) {
                $scope.errorMess = JSON.stringify(error);
            });
        }
    })

    .controller("BookDetailCtrl", function ($scope, Book){
        Book.get('0').then(function( result ) {
            $scope.book = result;
        }, function(error) {
        });
    })