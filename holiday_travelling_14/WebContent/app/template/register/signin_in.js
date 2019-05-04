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
				var str = JSON.stringify(data); 
				sessionStorage.stu = str; 
    			location.href = "/holiday_travelling_14/app/index.html";
	    		console.log(location.href);
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
});
var Encrypt = function (toEncode) {
  	var password = CryptoJS.SHA256(toEncode);
  	return password.toString();
}
var registerController = function($scope,$log,$timeout,$http,$filter,$uibModal,$uibModalInstance){
	$scope.modal={};
	var temPwd;
	$scope.modal.sex = 1;
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
				swal({
					title:"successed to sign up",
					type:"success",
					text:"now,you can try to login it",
					button:"ok"
				});
				$uibModalInstance.close();
	    	})
	    	.error(function (data, status) {
				swal({
					title:"failed to sign up",
					type:"error",
					text:"The account already exists",
					button:"ok"
				});
				$scope.modal.pwd=temPwd;
	    		$log.info("Failed to register");
	    	});
	 }
}
registerController.$inject = ["$scope", "$log", "$timeout","$http","$filter","$uibModal","$uibModalInstance"];   	