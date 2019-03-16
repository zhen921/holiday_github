var nmsSigninApp = angular.module('nmsSigninApp', [
	'myApp.filters', 'myApp.services', 'myApp.directives']);
nmsSigninApp.controller('signController', function ($scope, $http,$log,$timeout, $window) {
	$scope.login = function () {
	    var Encrypt = function (toEncode) {
	      var password = CryptoJS.SHA256(toEncode);
	      return password.toString();
	    }
	    if (angular.isUndefined($scope.password)) {
	      $scope.password = angular.element("#password").value;
	      $scope.username = angular.element("#username").value;
	    }
    	var password = Encrypt($scope.password);
    	var data = 'username=' + $scope.username.toLowerCase() + '&password=' + password;
    	var url = "/hems-web-ui" + "/signin";
    	$http({
    		method: 'POST',
    		url: url,
    		data: data,
    		headers: {
    			'Content-Type': 'application/x-www-form-urlencoded'
    		}
    	})
    	.success(function (data, status) {
    		location.href = "/hems-web-ui" + "/index";
    		console.log(location.href);
    		sessionStorage.navs_array = "";
    	})
    	.error(function (data, status) {
    		$log.info("Failed to login; status:" + status);
    	});
	}
});