myApp.controller('makePlanController',makePlanController);
    function makePlanController($scope,$http,$log,$uibModal){
        $scope.modal={};
        $scope.modal.province="内蒙古";
        $scope.modal.companysex="1";
        $scope.modal.totalcost="1";
        var obj = JSON.parse(sessionStorage.stu);
        $scope.modal.sno  = obj.sno;
        $scope.modal.selfsex  = obj.sex;
        $scope.tableShow=false;
        $scope.viewPlan=true;
        checkExistPlan();
       
        $scope.matchData=[{"sno":"123456","province":"内蒙古","companysex":2,"city":"呼和浩特市","view":"农大","totalperson":2,"totaltime":2,"totalcost":1,"startdate":1,"title":"谨慎","introduce":"按时\t\t\t\t\t\t\t","selfsex":2,"hot":68},
       /*  {"sno":"20001","province":"内蒙古","companysex":2,"city":"呼和浩特市","view":"农大","totalperson":1,"totaltime":2,"totalcost":1,"startdate":1,"title":"相约农大","introduce":"是\t","selfsex":1,"hot":56},
        {"sno":"2001","province":"内蒙古","companysex":3,"city":"呼和浩特市","view":"成吉思汗陵","totalperson":2,"totaltime":1,"totalcost":1,"startdate":1,"title":"成吉思汗","introduce":null,"selfsex":2,"hot":62},
        {"sno":"2002","province":"内蒙古","companysex":2,"city":"呼和浩特市","view":"响沙湾","totalperson":2,"totaltime":2,"totalcost":2,"startdate":3,"title":"响沙湾","introduce":"wu ","selfsex":2,"hot":75},
        {"sno":"2003","province":"内蒙古","companysex":2,"city":"呼和浩特市","view":"昭君墓旅游区","totalperson":2,"totaltime":1,"totalcost":1,"startdate":2,"title":"昭君墓","introduce":"发邮件\t\t","selfsex":1,"hot":68},
        {"sno":"2004","province":"内蒙古","companysex":2,"city":"呼和浩特市","view":"库不齐沙漠","totalperson":1,"totaltime":2,"totalcost":1,"startdate":1,"title":"去哪玩","introduce":"阿萨德\t\t\t\t","selfsex":2,"hot":56},
        {"sno":"2008","province":"内蒙古","companysex":2,"city":"呼和浩特市","view":"农大一日游","totalperson":3,"totaltime":1,"totalcost":1,"startdate":2,"title":"不知道","introduce":"都来玩哦\t\t\t\t","selfsex":2,"hot":56},
        {"sno":"2012","province":"内蒙古","companysex":2,"city":"呼伦贝尔市","view":"草原","totalperson":2,"totaltime":2,"totalcost":1,"startdate":2,"title":"去哪呀","introduce":"按时\t","selfsex":1,"hot":62},
        {"sno":"2001","province":"内蒙古","companysex":3,"city":"呼和浩特市","view":"成吉思汗陵","totalperson":2,"totaltime":1,"totalcost":1,"startdate":1,"title":"成吉思汗","introduce":null,"selfsex":2,"hot":62},
        {"sno":"2002","province":"内蒙古","companysex":2,"city":"呼和浩特市","view":"响沙湾","totalperson":2,"totaltime":2,"totalcost":2,"startdate":3,"title":"响沙湾","introduce":"wu ","selfsex":2,"hot":75},
        {"sno":"2003","province":"内蒙古","companysex":2,"city":"呼和浩特市","view":"昭君墓旅游区","totalperson":2,"totaltime":1,"totalcost":1,"startdate":2,"title":"昭君墓","introduce":"发邮件\t\t","selfsex":1,"hot":68},
        {"sno":"2004","province":"内蒙古","companysex":2,"city":"呼和浩特市","view":"库不齐沙漠","totalperson":1,"totaltime":2,"totalcost":1,"startdate":1,"title":"去哪玩","introduce":"阿萨德\t\t\t\t","selfsex":2,"hot":56},
        {"sno":"2008","province":"内蒙古","companysex":2,"city":"呼和浩特市","view":"农大一日游","totalperson":3,"totaltime":1,"totalcost":1,"startdate":2,"title":"不知道","introduce":"都来玩哦\t\t\t\t","selfsex":2,"hot":56},
        {"sno":"2012","province":"内蒙古","companysex":2,"city":"呼伦贝尔市","view":"草原","totalperson":2,"totaltime":2,"totalcost":1,"startdate":2,"title":"去哪呀","introduce":"按时\t","selfsex":1,"hot":62},
        {"sno":"2001","province":"内蒙古","companysex":3,"city":"呼和浩特市","view":"成吉思汗陵","totalperson":2,"totaltime":1,"totalcost":1,"startdate":1,"title":"成吉思汗","introduce":null,"selfsex":2,"hot":62},
        {"sno":"2002","province":"内蒙古","companysex":2,"city":"呼和浩特市","view":"响沙湾","totalperson":2,"totaltime":2,"totalcost":2,"startdate":3,"title":"响沙湾","introduce":"wu ","selfsex":2,"hot":75},
        {"sno":"2003","province":"内蒙古","companysex":2,"city":"呼和浩特市","view":"昭君墓旅游区","totalperson":2,"totaltime":1,"totalcost":1,"startdate":2,"title":"昭君墓","introduce":"发邮件\t\t","selfsex":1,"hot":68},
        {"sno":"2004","province":"内蒙古","companysex":2,"city":"呼和浩特市","view":"库不齐沙漠","totalperson":1,"totaltime":2,"totalcost":1,"startdate":1,"title":"去哪玩","introduce":"阿萨德\t\t\t\t","selfsex":2,"hot":56},
        {"sno":"2008","province":"内蒙古","companysex":2,"city":"呼和浩特市","view":"农大一日游","totalperson":3,"totaltime":1,"totalcost":1,"startdate":2,"title":"不知道","introduce":"都来玩哦\t\t\t\t","selfsex":2,"hot":56},
        {"sno":"2012","province":"内蒙古","companysex":2,"city":"呼伦贝尔市","view":"草原","totalperson":2,"totaltime":2,"totalcost":1,"startdate":2,"title":"去哪呀","introduce":"按时\t","selfsex":1,"hot":62},
        {"sno":"2001","province":"内蒙古","companysex":3,"city":"呼和浩特市","view":"成吉思汗陵","totalperson":2,"totaltime":1,"totalcost":1,"startdate":1,"title":"成吉思汗","introduce":null,"selfsex":2,"hot":62},
        {"sno":"2002","province":"内蒙古","companysex":2,"city":"呼和浩特市","view":"响沙湾","totalperson":2,"totaltime":2,"totalcost":2,"startdate":3,"title":"响沙湾","introduce":"wu ","selfsex":2,"hot":75},
        {"sno":"2003","province":"内蒙古","companysex":2,"city":"呼和浩特市","view":"昭君墓旅游区","totalperson":2,"totaltime":1,"totalcost":1,"startdate":2,"title":"昭君墓","introduce":"发邮件\t\t","selfsex":1,"hot":68},
        {"sno":"2004","province":"内蒙古","companysex":2,"city":"呼和浩特市","view":"库不齐沙漠","totalperson":1,"totaltime":2,"totalcost":1,"startdate":1,"title":"去哪玩","introduce":"阿萨德\t\t\t\t","selfsex":2,"hot":56},
        {"sno":"2008","province":"内蒙古","companysex":2,"city":"呼和浩特市","view":"农大一日游","totalperson":3,"totaltime":1,"totalcost":1,"startdate":2,"title":"不知道","introduce":"都来玩哦\t\t\t\t","selfsex":2,"hot":56},
        {"sno":"2012","province":"内蒙古","companysex":2,"city":"呼伦贝尔市","view":"草原","totalperson":2,"totaltime":2,"totalcost":1,"startdate":2,"title":"去哪呀","introduce":"按时\t","selfsex":1,"hot":62},
        {"sno":"2001","province":"内蒙古","companysex":3,"city":"呼和浩特市","view":"成吉思汗陵","totalperson":2,"totaltime":1,"totalcost":1,"startdate":1,"title":"成吉思汗","introduce":null,"selfsex":2,"hot":62},
        {"sno":"2002","province":"内蒙古","companysex":2,"city":"呼和浩特市","view":"响沙湾","totalperson":2,"totaltime":2,"totalcost":2,"startdate":3,"title":"响沙湾","introduce":"wu ","selfsex":2,"hot":75},
        {"sno":"2003","province":"内蒙古","companysex":2,"city":"呼和浩特市","view":"昭君墓旅游区","totalperson":2,"totaltime":1,"totalcost":1,"startdate":2,"title":"昭君墓","introduce":"发邮件\t\t","selfsex":1,"hot":68},
        {"sno":"2004","province":"内蒙古","companysex":2,"city":"呼和浩特市","view":"库不齐沙漠","totalperson":1,"totaltime":2,"totalcost":1,"startdate":1,"title":"去哪玩","introduce":"阿萨德\t\t\t\t","selfsex":2,"hot":56},
        {"sno":"2008","province":"内蒙古","companysex":2,"city":"呼和浩特市","view":"农大一日游","totalperson":3,"totaltime":1,"totalcost":1,"startdate":2,"title":"不知道","introduce":"都来玩哦\t\t\t\t","selfsex":2,"hot":56},
        {"sno":"2012","province":"内蒙古","companysex":2,"city":"呼伦贝尔市","view":"草原","totalperson":2,"totaltime":2,"totalcost":1,"startdate":2,"title":"去哪呀","introduce":"按时\t","selfsex":1,"hot":62},
        {"sno":"2001","province":"内蒙古","companysex":3,"city":"呼和浩特市","view":"成吉思汗陵","totalperson":2,"totaltime":1,"totalcost":1,"startdate":1,"title":"成吉思汗","introduce":null,"selfsex":2,"hot":62},
        {"sno":"2002","province":"内蒙古","companysex":2,"city":"呼和浩特市","view":"响沙湾","totalperson":2,"totaltime":2,"totalcost":2,"startdate":3,"title":"响沙湾","introduce":"wu ","selfsex":2,"hot":75},
        {"sno":"2003","province":"内蒙古","companysex":2,"city":"呼和浩特市","view":"昭君墓旅游区","totalperson":2,"totaltime":1,"totalcost":1,"startdate":2,"title":"昭君墓","introduce":"发邮件\t\t","selfsex":1,"hot":68},
        {"sno":"2004","province":"内蒙古","companysex":2,"city":"呼和浩特市","view":"库不齐沙漠","totalperson":1,"totaltime":2,"totalcost":1,"startdate":1,"title":"去哪玩","introduce":"阿萨德\t\t\t\t","selfsex":2,"hot":56},
        {"sno":"2008","province":"内蒙古","companysex":2,"city":"呼和浩特市","view":"农大一日游","totalperson":3,"totaltime":1,"totalcost":1,"startdate":2,"title":"不知道","introduce":"都来玩哦\t\t\t\t","selfsex":2,"hot":56},
        {"sno":"2012","province":"内蒙古","companysex":2,"city":"呼伦贝尔市","view":"草原","totalperson":2,"totaltime":2,"totalcost":1,"startdate":2,"title":"去哪呀","introduce":"按时\t","selfsex":1,"hot":62},
        {"sno":"2001","province":"内蒙古","companysex":3,"city":"呼和浩特市","view":"成吉思汗陵","totalperson":2,"totaltime":1,"totalcost":1,"startdate":1,"title":"成吉思汗","introduce":null,"selfsex":2,"hot":62},
        {"sno":"2002","province":"内蒙古","companysex":2,"city":"呼和浩特市","view":"响沙湾","totalperson":2,"totaltime":2,"totalcost":2,"startdate":3,"title":"响沙湾","introduce":"wu ","selfsex":2,"hot":75},
        {"sno":"2003","province":"内蒙古","companysex":2,"city":"呼和浩特市","view":"昭君墓旅游区","totalperson":2,"totaltime":1,"totalcost":1,"startdate":2,"title":"昭君墓","introduce":"发邮件\t\t","selfsex":1,"hot":68},
        {"sno":"2004","province":"内蒙古","companysex":2,"city":"呼和浩特市","view":"库不齐沙漠","totalperson":1,"totaltime":2,"totalcost":1,"startdate":1,"title":"去哪玩","introduce":"阿萨德\t\t\t\t","selfsex":2,"hot":56},
        {"sno":"2008","province":"内蒙古","companysex":2,"city":"呼和浩特市","view":"农大一日游","totalperson":3,"totaltime":1,"totalcost":1,"startdate":2,"title":"不知道","introduce":"都来玩哦\t\t\t\t","selfsex":2,"hot":56},
       */  {"sno":"2012","province":"内蒙古","companysex":2,"city":"呼伦贝尔市","view":"草原","totalperson":2,"totaltime":2,"totalcost":1,"startdate":2,"title":"去哪呀","introduce":"按时\t","selfsex":1,"hot":62},
        {"sno":"2015122147776","province":"内蒙古","companysex":2,"city":"呼和浩特市","view":"昭君墓旅游区","totalperson":2,"totaltime":1,"totalcost":1,"startdate":1,"title":"昭君","introduce":"再次\t\t\t\t\t","selfsex":1,"hot":62}];
       
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
        $scope.tableIntoModifyPlan = tableIntoModifyPlan;
        $scope.viewProfile = viewProfile;
        
        getProvinceName();
        getCityName();
        
        $scope.gridOptions = {
            data : 'matchData',
            enableGridMenu: true,
            enableFiltering: true,
            enableRowSelection: true,
            enableRowHeaderSelection : false,
            multiSelect: false,  
            enableSorting: true,
            showGridFooter: true,
            showFooter: false,
            enablePagination: true,
            enablePaginationControls: true, 
            paginationPageSizes: [50, 100, 200], 
            paginationPageSize: 20,
            rowTemplate:'<div><div context-menu="grid.appScope.rightMenu(row)" ng-dblclick="grid.appScope.rightMenu(row)" ng-repeat="(colRenderIndex, col) in colContainer.renderedColumns track by col.colDef.name" class="ui-grid-cell" ui-grid-cell ></div></div>',
            columnDefs : [
                {
                    field : 'title',
                    displayName : 'title'
                },
                {
                    field : 'province',
                    displayName : 'province'
                },
                {
                    field : 'city',
                    displayName : 'city'
                },
                {
                    field : 'view',
                    displayName : "view"
                }
            ],
            onRegisterApi: function(gridApi) {
                gridApi.selection.on.rowSelectionChanged($scope, function(row) {
                    $scope.selectedData = gridApi.selection.getSelectedRows();
                });
                $scope.gridApi = gridApi;
            }
        };

        $scope.rightMenu = rightMenu;
        function rightMenu(row){
            $scope.gridApi.selection.clearSelectedRows();
            $scope.gridApi.selection.selectRow(row.entity);
            var operationList = [
                ['查看详细计划',function($itemScope,$event){
                    $scope.tableIntoModifyPlan(row.entity.sno);
                }],
                ['打开个人主页',function($itemScope,$event){
                    $scope.viewProfile(row.entity.sno);
                }]
            ];
            return operationList;
        }
        //右键查看个人信息
        function viewProfile(sno){
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
        //查看计划
        function tableIntoModifyPlan(sno){
            if(sno.length != 0)
                var url = "/holiday_travelling_14/userback/tableIntoModifyPlan?sno="+sno;
            else
                var url = "/holiday_travelling_14/userback/tableIntoModifyPlan?sno="+obj.sno;
            $http({
                method: 'GET',
                url: url
            })
            .success(function (data, status) {
                $scope.modal=data[0];
                $scope.tableShow=false;
                $scope.modal.companysex = $scope.modal.companysex+"";
                $scope.modal.totalcost = $scope.modal.totalcost+"";
            })
            .error(function (data, status) {
                $log.info();
            });
        }
        //初始化的时候检查是否有发布的计划
        function checkExistPlan(){
            var url = "/holiday_travelling_14/userback/checkExistPlan?sno="+obj.sno;
            $http({
                method: 'GET',
                url: url
            })
            .success(function (data, status) {
                $scope.matchData=data;
                $scope.tableShow=true;
                $scope.viewPlan=false;
            })
            .error(function (data, status) {
                $log.info();
            });
        }
        //发布计划
        function releasePlan(){
            $scope.modal.companysex = parseInt($scope.modal.companysex);
            $scope.modal.totalcost = parseInt($scope.modal.totalcost);
            var url = "/holiday_travelling_14/userback/planRelease";
            $http({
                method: 'POST',
                url: url,
                data:$scope.modal
            })
            .success(function (data, status) {
                $scope.matchData=data;
                if($scope.matchData.length>0)
                    swal({title:"发布成功",text:"为您找到"+$scope.matchData.length+"个相似计划",type:"success"});
                $scope.tableShow=true;
                $scope.viewPlan=false;
            })
            .error(function (data, status) {
                swal({title:"计划已经存在，请勿重复发布",type:"error"});
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
    var viewProfileController = function($scope,data,$uibModalInstance){
        $scope.modal=data;
        if($scope.modal.sex == 1)
            $scope.modal.sex='男';
        else
            $scope.modal.sex='女';
    }
    viewProfileController.$inject = ["$scope","data","$uibModalInstance"]; 