myApp.controller('mainPageController', function ($scope, $http,$log,$timeout, $window,$uibModal) {
    var obj = JSON.parse(sessionStorage.stu);
    getProfile();
    checkInform();
    $scope.clearInform = clearInform;

    this.sidebarToggle = {
        left : false
    };
    this.sidebarStat = function(event) {
        if (!angular.element(event.target).parent().hasClass('active')) {
            this.sidebarToggle.left = false;
        }
    }
    function getProfile(){
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
    function clearInform(){
        if(obj.inform == 0)
            return;
        url = "/holiday_travelling_14/userback/clearInform?sno="+obj.sno;
        $http({
           method: 'PUT',
           url: url
        })
        .success(function (data, status) {
            obj.inform=0;
            sessionStorage.stu=JSON.stringify(obj);
            $scope.informPath="inform.jpg"; 
        })
        .error(function (data, status) {
           $log.info("Failed to clear inform");
        });
    }
    function checkInform(){
        if(obj.inform == 0)
            $scope.informPath="inform.jpg"
        else
            $scope.informPath="informred.jpg"
    }
});
