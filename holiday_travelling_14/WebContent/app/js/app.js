'use strict';


// Declare app level module which depends on filters, and services
var myApp=angular.module('myApp', ['myApp.filters', 'myApp.services', 'myApp.directives','ui.router','ui.bootstrap','ngAnimate']);
 myApp.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {
	 $stateProvider.state ('system.User Group', {
         url: '/group',
         templateUrl: 'templates/system/group.html',
         controller : 'systemGroupController',
     })
     .state ('system.User', {
         url: '/user',
         templateUrl: 'templates/system/user.html',
         controller : 'systemUserController',
     })
//    $routeProvider.when('/login', {templateUrl: 'user_login.html', controller: MyCtrl1});
//    $routeProvider.when('/register', {templateUrl: 'partials/partial2.html', controller: MyCtrl2});
    $urlRouterProvider.otherwise('/login');
  }]);
