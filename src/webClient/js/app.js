//Define an angular module for our app
angular.module("ngClient", ["ngClient.controllers", "ngClient.services", "ngRoute"])

//Define Routing for app
//Uri /AddNewOrder -> template AddOrder.html and Controller AddOrderController
//Uri /ShowOrders -> template ShowOrders.html and Controller AddOrderController
    .config(['$routeProvider',
        function ($routeProvider) {
            $routeProvider.when('/AddNewOrder', {
                templateUrl: 'partials/dummy.html',
                controller: 'AddOrderController'
            }).when('/ShowOrders', {
                templateUrl: 'partials/dummy2.html',
                controller: 'ShowOrdersController'
            }).when('/book-list', {
                templateUrl: 'partials/book-list.html',
                controller: 'BookCtrl'
            }).when('/book-detail/:id', {
                templateUrl: 'partials/book-detail.html',
                controller: 'BookDetailCtrl'
            }).otherwise({
                redirectTo: '/AddNewOrder'
            });
        }])

    .controller('AddOrderController', function ($scope) {
        $scope.message = 'This is Add new order screen';
    })


    .controller('ShowOrdersController', function ($scope) {
        $scope.message = 'This is Show orders screen';
    });