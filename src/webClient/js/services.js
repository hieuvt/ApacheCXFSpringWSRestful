/**
 * Created by hieu.vutrong on 1/6/2015.
 */

angular.module('ngClient.services', ['ngResource'])
    .factory("Book", function ($resource, $q) {
        var settings = {};
        var bookResource = $resource(
            "http://localhost:8080/bookservice/getAllBooks"
        );

        settings.query = function(){
            var deferredObject = $q.defer();
            bookResource.query().$promise.then(function(result) {
                deferredObject.resolve(result);
            }, function(errorMsg) {
                deferredObject.reject(errorMsg);
            });
            return deferredObject.promise;
        }

        return settings;
    })
