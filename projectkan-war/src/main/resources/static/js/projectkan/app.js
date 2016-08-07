/**
 * Created by willlobato on 07/08/16.
 */
angular.module('mainApp',['ngRoute'])
    .config(['$routeProvider', function($routeProvider){
        $routeProvider
            .when('/',{template:'This is the default Route'})
            .when('/computers',{template:'This is the computers Route'})
            .when('/printers',{template:'This is the printers Route'})
            .otherwise({redirectTo:'/'});
    }]);
