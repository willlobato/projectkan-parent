/**
 * Created by willlobato on 07/08/16.
 */
'use strict';
var mainApp = angular.module('mainApp', ['NavigationService']);
mainApp.controller('projectkanController', function ($scope, NavigationService) {

    

    NavigationService.buildNavigationBar().then(
        function (data) {
            $scope.navigation = data;
            console.log(data);
        },
        function(errResponse) {
            console.error('Error while fetching Users');
        }
    );

});
