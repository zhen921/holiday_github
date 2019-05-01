myApp.controller('mainPageController', function ($scope, $http,$log,$timeout, $window,$uibModal) {
    this.sidebarToggle = {
        left : false
    };
    this.sidebarStat = function(event) {
        if (!angular.element(event.target).parent().hasClass('active')) {
            this.sidebarToggle.left = false;
        }
    }

});
