/**
 * Created by willlobato on 07/08/16.
 */
'use strict';
var mainApp = angular.module('mainApp', ['NavigationService']);
mainApp.controller('projectkanController', function ($scope, NavigationService) {
    var self = this;

    var navigationBar = {

        build : function () {
            NavigationService.buildNavigationBar().then(
                function (data) {
                    self.navigation = data;

                    console.log(data);
                },
                function(errResponse) {
                    console.error('Error while fetching Users');
                }
            );
        },

    }

    navigationBar.build();

});
