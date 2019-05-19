myApp.controller('clusterController', clusterController)
function clusterController($scope,$http, $log,$timeout,$uibModal,$state) {
   var obj = JSON.parse(sessionStorage.stu);
   $scope.checkCondition=checkCondition;

   function checkCondition(){
      url = "/holiday_travelling_14/userback/checkCondition?sno="+obj.sno;
      $http({
         method: 'GET',
         url: url
      })
      .success(function (data, status) {
        
      })
      .error(function (data, status) {
         swal({title:"获取最新计划列表失败",type:"error"});
      });
   }
}