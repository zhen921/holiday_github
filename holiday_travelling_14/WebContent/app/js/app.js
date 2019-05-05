'use strict';
// Declare app level module which depends on filters, and services
var myApp=angular.module('myApp', [
    'myApp.filters', 
    'myApp.services', 
    'myApp.directives',
    'ui.router',
    'ui.bootstrap',
    'ngAnimate'
]);

myApp.config(function ($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise('/dashboard');
    $stateProvider.state ('dashboard', {
        url: '/dashboard',
        templateUrl: 'template/dashboard/dashboard.html',
        controller : 'dashboardController',
    })
    .state ('profile', {
        url: '/profile',
        templateUrl: 'template/profile/profile.html',
        controller : 'profileController'
    })
    .state ('makePlan', {
        url: '/makePlan',
        templateUrl: 'template/plan/makePlan.html',
        controller : 'makePlanController'
    })
 });