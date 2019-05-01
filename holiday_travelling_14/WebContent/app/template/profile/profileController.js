myApp.controller('profileController', 
   ["$scope","$http","$log","$timeout","$window","$uibModal",
   function($scope,$http, $log,$timeout,$window,$uibModal,$state) {
   $scope.getProfile = function(){
      //get session data
      str = sessionStorage.stu; 
      obj = JSON.parse(str);
      url = "/holiday_travelling_14/userback/getProfileBySno?sno="+obj.sno;
      $http({
         method: 'GET',
         url: url
      })
      .success(function (data, status) {
      })
      .error(function (data, status) {
         $log.info("Failed to get data; status:" + status);
      });
   }
   $scope.getProfile();


}]);