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
	var temPwd,tempVerificationCode;
	$scope.modal.sex = 1;
	$scope.pwdNotEqualShow = false;

	$scope.pwdNotEqual = pwdNotEqual;
	$scope.confirm = confirm;
	$scope.sendVerificationCode = sendVerificationCode;
	$scope.verificatifyCode = verificatifyCode;

	function sendVerificationCode(){
		tempVerificationCode=Math.floor(Math.random()*8999)+1000;
		var url = "/holiday_travelling_14/userback/getEmailVerificationCode?tempVerificationCode="+tempVerificationCode+"&email="+$scope.modal.email;
    	$http({
    		method: 'GET',
    		url: url
    	})
    	.success(function (data, status) {
			swal({
				title:'发送成功',
				text:"验证码已发送到您的邮箱，请注意查收!",
				type:'success',
				timer: 2000, 
				showConfirmButton: false 
			});
    	})
    	.error(function (data, status) {
    		$log.info("Failed to send verification code; status:" + status);
    	});

	}

	function verificatifyCode(){
		if($scope.verificationCode != tempVerificationCode)
			$scope.setForm.code.$invalid=true;
	}
	function pwdNotEqual(){
		if(typeof $scope.modal.pwd !== 'undefined'&& typeof $scope.rePwd !== 'undefined')
				if($scope.modal.pwd.length>0&&$scope.rePwd.length>0)
					if($scope.modal.pwd != $scope.rePwd)
						$scope.pwdNotEqualShow=true;
					else
						$scope.pwdNotEqualShow=false;
				else
					$scope.pwdNotEqualShow=false;
	}
	function confirm(){
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
					title:"注册成功",
					type:"success",
					button:"确定"
				});
				$uibModalInstance.close();
	    	})
	    	.error(function (data, status) {
				swal({
					title:"注册失败",
					type:"error",
					text:"该用户已存在，不能重复注册！",
					button:"确定"
				});
				$scope.modal.pwd=temPwd;
	    		$log.info("Failed to register");
	    	});
	}
}
registerController.$inject = ["$scope", "$log", "$timeout","$http","$filter","$uibModal","$uibModalInstance"];   	