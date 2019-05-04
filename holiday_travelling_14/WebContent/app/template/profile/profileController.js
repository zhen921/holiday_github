myApp.controller('profileController', 
   ["$scope","$http","$log","$timeout","$window","$uibModal",
   function($scope,$http, $log,$timeout,$window,$uibModal,$state) {
	   getProfile();
		
		$scope.updateProfile = function(){
			url = "/holiday_travelling_14/userback/saveProfileBySno";
			$http({
				method: 'PUT',
				url: url,
				data:$scope.modal
			})
			.success(function (data, status) {
				swal({title:'Successfully Saved',type:'success'});
			})
			.error(function (data, status) {
				swal({title:'Update Failed',type:'error'});
				$log.info("Failed to get data; status:" + status);
			});
		}

		$scope.modifyPwd = function () {
			$uibModal.open({
					templateUrl: 'template/profile/modifyPwd.html',
					controller: modifyPwdController,
					backdrop : 'static',
					size:'md',
					resolve: {
						 data: function() {
							  return $scope.modal;
						 }
					}        
			  });
		}
	   
	   function getProfile(){
		    //get session data
		    str = sessionStorage.stu; 
		    obj = JSON.parse(str);
		    url = "/holiday_travelling_14/userback/getProfileBySno?sno="+obj.sno;
		    $http({
		       method: 'GET',
		       url: url
		    })
		    .success(function (data, status) {
				 $scope.modal=data;
		    })
		    .error(function (data, status) {
		       $log.info("Failed to get data; status:" + status);
		    });
		 }
}]);

var modifyPwdController = function($scope,data,$log,$http,$uibModal,$uibModalInstance){
	var profileData = data;
	$scope.oldPwdMessage=false;
	$scope.pwdNotEqualShow=false;
	$scope.confirm=function(){
		profileData.pwd=Encrypt($scope.modal.new);
		url = "/holiday_travelling_14/userback/saveProfileBySno";
		$http({
			method: 'PUT',
			url: url,
			data:profileData
		})
		.success(function (data, status) {
			$uibModalInstance.close();
			swal({title:'Successfully Modified',type:'success'});
		})
		.error(function (data, status) {
			swal({title:'Failed to modify',type:'error'});
		});
	}
	$scope.pwdNotEqual = function(){
		if(typeof $scope.modal.new !== 'undefined'&& typeof $scope.modal.renew !== 'undefined')
			if($scope.modal.new.length>0&&$scope.modal.renew.length>0)
				if($scope.modal.new != $scope.modal.renew)
					$scope.pwdNotEqualShow=true;
				else
					$scope.pwdNotEqualShow=false;
			else
				$scope.pwdNotEqualShow=false;
	}

	$scope.checkOldPwd = function(){
		if(profileData.pwd != Encrypt($scope.modal.current))
			$scope.oldPwdMessage=true;
		else
			$scope.oldPwdMessage=false;
	}
	var Encrypt = function (toEncode) {
		var password = CryptoJS.SHA256(toEncode);
		return password.toString();
 }
}
modifyPwdController.$inject = ["$scope","data","$log","$http","$uibModal","$uibModalInstance"];   	