/**
 * Created by willlobato on 03/08/16.
 */
'use strict';

var App = angular.module('mainApp',['ui.router']);

App.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){

    $urlRouterProvider.otherwise("/index")

    $stateProvider
        .state('index', {
            url: "/index",
            templateUrl: 'index',
            controller : "IndexController as indexController",
            resolve: {
                async: ['IndexService', function(IndexService) {
                    return IndexService.fetchCategoryList();
                }]
            }
        })

        .state('category.list', {
            url: '/{categoryId:[A-Za-z]{0,9}}',
            templateUrl: function(params){ return 'category/' + params.categoryId; },
            controller : "ItemListController as itemListCtrl",
            resolve: {
                async: ['ItemService', '$stateParams', function(ItemService, $stateParams) {
                    return ItemService.fetchAllItems($stateParams.categoryId);
                }]
            }
        })

        .state('category.list.detail', {
            url: '/{itemId:[0-9]{1,9}}',
            templateUrl: function(params){ return 'category/' + params.categoryId +'/'+params.itemId; },
            controller : "ItemDetailsController as itemDetailsCtrl",
            resolve: {
                async: ['ItemService', '$stateParams', function(ItemService, $stateParams) {
                    return ItemService.fetchSpecificItem($stateParams.categoryId, $stateParams.itemId);
                }]
            }
        })

}]);