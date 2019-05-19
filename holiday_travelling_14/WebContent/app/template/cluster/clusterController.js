myApp.controller('dashboardController', dashboardController)
function dashboardController($scope,$http, $log,$timeout,$uibModal,$state) {
   var obj = JSON.parse(sessionStorage.stu);
   $scope.viewProfileDetail=viewProfileDetail;
   $scope.viewPlanDetail = viewPlanDetail;
   $scope.changePage=changePage;
   var currentPage=0;

   if(obj.college != null)
      getLatestPlan(0);

   function changePage(para){
      if(para == 'last' )
         if(currentPage>0){
            currentPage=currentPage-1;
            getLatestPlan(currentPage*3)
         }else{
            swal({
               title:'',
               text:"当前页为首页!",
               type:'warning',
               timer: 2000, 
               showConfirmButton: false 
            });
         }
      else
         if($scope.modal.length == 3){
            currentPage=currentPage+1;
            getLatestPlan(currentPage*3)
         }else{
            swal({
               title:'',
               text:"当前页为最后一页!",
               type:'warning',
               timer: 2000, 
               showConfirmButton: false 
            });
         }
            
   }

   //获取计划的详细信息
   function viewPlanDetail(sno){
      $state.go('makePlan',{'sno':sno});
   }

   //获取发计划人的个人信息
   function viewProfileDetail(sno){
      url = "/holiday_travelling_14/userback/getProfileBySno?sno="+sno;
		    $http({
		       method: 'GET',
		       url: url
		    })
		    .success(function (data, status) {
                 $uibModal.open({
                    templateUrl: 'template/plan/profiledetail.html',
                    controller: viewProfileController,
                    backdrop : 'static',
                    size:'md',
                    resolve: {
                            data: function() {
                                return data;
                            }
                    }        
                });
		    })
		    .error(function (data, status) {
		       $log.info("Failed to get data; status:" + status);
		    });
   }

   //进入主页的时候首先获取校友发布的最新计划
   function getLatestPlan(currentPage){
      //对中文编码传输，解决传输过程中的乱码问题
      var college=encodeURI(encodeURI(obj.college))
      url = "/holiday_travelling_14/userback/getLatestPlan?college="+college+"&index="+currentPage;
      $http({
         method: 'GET',
         url: url
      })
      .success(function (data, status) {
         $scope.modal=data;
      })
      .error(function (data, status) {
         $log.info("获取最新计划列表失败");
         swal({title:"获取最新计划列表失败",type:"error"});
      });
   }
}