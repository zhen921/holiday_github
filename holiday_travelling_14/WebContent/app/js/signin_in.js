var nmsSigninApp = angular.module('nmsSigninApp', [
	'myApp.filters', 'myApp.services', 'myApp.directives']);
nmsSigninApp.controller('signController', function ($scope, $http,$log,$timeout, $window) {
	$scope.errorMsg=false;
	$scope.login = function () {
	    var Encrypt = function (toEncode) {
	      var password = CryptoJS.SHA256(toEncode);
	      return password.toString();
	    }
	    if(angular.isUndefined($scope.username)||angular.isUndefined($scope.password)){
	    	return;
	    }
	    // if (angular.isUndefined($scope.password)) {
	    //   $scope.password = angular.element("#password").value;
	    //   $scope.username = angular.element("#username").value;
	    // }
    	var password = Encrypt($scope.password);
    	//var data = 'sno=' + $scope.username.toLowerCase() + '&password=' + password;
    	var user = {
    			'sno':$scope.username,
    			'pwd':password
    		};
    	var url = "/holiday_travelling_14/userback/login";
    	$http({
    		method: 'POST',
    		url: url,
    		data:user,
    		headers: {
    			'Content-Type':'application/json;charset=utf-8'
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
	//$scope.errorMsg = true;
	// $scope.detectCapsLock = function (event) {
	//     if ($scope.capitalStatus) {
	//       return;
	//     }
	//     var e = event || window.event;
	//     var keyCode = e.keyCode || e.which;
	//     var isShift = e.shiftKey || (keyCode == 16) || false;
	//     if (((keyCode >= 65 && keyCode <= 90) && !isShift) || ((keyCode >= 97 && keyCode <= 122) && isShift)) {
	//       $scope.capitalStatus = true;
	//     } else {
	//       $scope.capitalStatus = false;
	//     }
	// }
	// $scope.upCapsLock = function (event) {
 //    var e = event || window.event;
	//     if (e.keyCode == 20 && capital) {
	//       $scope.capitalStatus = !$scope.capitalStatus;
	//     }
	//     return false;
	// }
	// $scope.setCapitalNone = function (event) {
	//     $scope.capitalStatus = false;
	// }
	// $scope.initialPassword = function () {
	//     $scope.password = "";
	// }
});