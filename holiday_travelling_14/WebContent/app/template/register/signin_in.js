var nmsSigninApp = angular.module('nmsSigninApp', ['ui.bootstrap','ngAnimate']);
nmsSigninApp.controller('signController', function ($scope, $http,$log,$timeout, $window,$uibModal) {
	$scope.errorMsg=false;
	$scope.login = function () {
	    if(angular.isUndefined($scope.username)||angular.isUndefined($scope.password)){
	    	return;
	    }
    	var password = Encrypt($scope.password);
    	var url = "/holiday_travelling_14/userback/login";
    	$http({
    		method: 'POST',
    		url: url,
    		data:{
    			'sno':$scope.username,
    			'pwd':password },
    		headers: {
    			'Content-Type':'application/json;charset=utf-8'
    		}
    	})
    	.success(function (data, status) {
    		if(data.sno != null){
    			//location.href = "/hems-web-ui" + "/index";
	    		console.log(location.href);
	    		sessionStorage.navs_array = "";
    		}else{
    			$scope.errorMsg=true;
    		}
    	})
    	.error(function (data, status) {
    		$log.info("Failed to login; status:" + status);
    	});
	}
	$scope.register = function () {
		$uibModal.open({
            templateUrl: 'app/template/register/user_register.html',
            controller: registerController,
            backdrop : 'static',
            size:'md',
            resolve: {
                data: function() {
                    return null;
                }
            }        
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
var Encrypt = function (toEncode) {
  	var password = CryptoJS.SHA256(toEncode);
  	return password.toString();
}
var registerController = function($scope,$log,$timeout,$http,$filter,$uibModal,$uibModalInstance){
	 $scope.modal={};
	 var temPwd;
	 $scope.modal.sex = 1;
	 $scope.gender=function(gender){
		 if(gender == 2)
			 $scope.modal.sex = 2;
		 else
			 $scope.modal.sex = 1;
	 }
	 $scope.confirm = function(){
		 url="/holiday_travelling_14/userback/register";
		 temPwd=$scope.modal.pwd;
		 $scope.modal.pwd = Encrypt($scope.modal.pwd);
		 $http({
	    		method: 'POST',
	    		url: url,
	    		data:$scope.modal,
	    		headers: {
	    			'Content-Type':'application/json;charset=utf-8'
	    		}
	    	})
	    	.success(function (data, status) {
	    		if(data.data=="success"){
	    			swal({
	    				title:"successed to sign up",
	    				type:"success",
	    				text:"now,you can try to login it",
	    				button:"ok"
	    			});
	    			$uibModalInstance.close();
	    		}else{
	    			swal({
	    				title:"failed to sign up",
	    				type:"error",
	    				text:"The account already exists",
	    				button:"ok"
	    			});
	    			$scope.modal.pwd=temPwd;
	    		}
	    	})
	    	.error(function (data, status) {
	    		$log.info("Failed to register");
	    	});
	 }
}
registerController.$inject = ["$scope", "$log", "$timeout","$http","$filter","$uibModal","$uibModalInstance"];   	