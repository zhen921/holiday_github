myApp.controller('makePlanController',makePlanController);
    function makePlanController($scope,$http,$log){
        $scope.modal={};
        $scope.modal.province="内蒙古";
        $scope.modal.companysex="1";
        $scope.modal.totalcost="1";
        $scope.genderList=[
            {"value":1,"name":"boy"},
            {"value":2,"name":"girl"},
            {"value":3,"name":"whatever"}
        ];
        $scope.costList=[
            {"value":1,"name":"0~200"},
            {"value":3,"name":"200~400"},
            {"value":5,"name":"400~600"},
            {"value":7,"name":"600~800"},
            {"value":9,"name":"800+"}
        ];
        $scope.getCityName = getCityName;
        $scope.releasePlan = releasePlan;
        
        getProvinceName();
        getCityName();
        
        function releasePlan(){
            var obj = JSON.parse(sessionStorage.stu);
            $scope.modal.sno  = obj.sno;
            $scope.modal.selfsex  = obj.sex;
            $scope.modal.companysex = parseInt($scope.modal.companysex);
            $scope.modal.totalcost = parseInt($scope.modal.totalcost);
            var url = "/holiday_travelling_14/userback/planRelease";
            $http({
                method: 'POST',
                url: url,
                data:$scope.modal
            })
            .success(function (data, status) {
                
            })
            .error(function (data, status) {
            $log.info();
            });
        }
        function getCityName(){
            var provinceCode;
            if(typeof $scope.provinceList == 'undefined')
                provinceCode="150000";
            else
                provinceCode=getProvinceCode($scope.modal.province,$scope.provinceList);
            
            url = "/holiday_travelling_14/userback/getCityName?provinceCode="+provinceCode;
            $http({
            method: 'GET',
            url: url
            })
            .success(function (data, status) {
                $scope.cityList=data;
                $scope.modal.city=data[0].name;
            })
            .error(function (data, status) {
            $log.info();
            });
        } 
        function getProvinceName(){
            url = "/holiday_travelling_14/userback/getProvinceName";
            $http({
            method: 'GET',
            url: url
            })
            .success(function (data, status) {
                $scope.provinceList=data;
            })
            .error(function (data, status) {
            $log.info();
            });
        }
        function getProvinceCode(province,provinceList){
            var code;
            angular.forEach(provinceList, function(item){  
                if(item.name == province){
                    code=item.code;
                }  
            }); 
            return code;
        }
    }