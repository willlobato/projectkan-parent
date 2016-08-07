/**
 * Created by willlobato on 07/08/16.
 */
'use strict';
var navigationService = angular.module('NavigationService', []);
navigationService.service('NavigationService', ['$http', '$q', function ($http, $q) {

    return {
        buildNavigationBar: function () {
            var deferred = $q.defer();
            $http.get('navigation').then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function (errResponse) {
                    console.error('Error!');
                    deferred.reject(errResponse);
                }
            );
            return deferred.promise;
        }
    }

}]);