/**
 * Created by willlobato on 07/08/16.
 */
'use strict';
angular.module('mainApp', []).service('NavigationService', ['$http', function ($http) {

    return {
        buildNavigationBar: function () {
            return $http.get('navigation').then(

                function (response) {
                    console.log(response.data);
                },
                function (errResponse) {

                }

            )
        }
    }

}]);