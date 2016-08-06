/**
 * Created by willlobato on 03/08/16.
 */
var mainApp = angular.module("mainApp", ['ngRoute']);
console.log(mainApp);
mainApp.config(['$routeProvider', function($routeProvider) {
    //alert($routeProvider);
    // $routeProvider.
    //
    // when('/addStudent', {
    //     templateUrl: 'addStudent.htm', controller: 'AddStudentController'
    // }).
    //
    // when('/viewStudents', {
    //     templateUrl: 'viewStudents.htm', controller: 'ViewStudentsController'
    // }).
    //
    // otherwise({
    //     redirectTo: '/addStudent'
    // });

}]);