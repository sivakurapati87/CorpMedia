'use strict';

App.controller('Add_Leave_Type_Controller', ['$scope','$location','$rootScope','$http','$state', function($scope,$location,$rootScope,$http,$state) {

	
		
	//Save leave type
	$scope.addLeaveType = function(){
		if($rootScope.selectedCompanyObj){
			$scope.addLeaveTypeJson.companyId = $rootScope.selectedCompanyObj.companyId;
			if(!$scope.addLeaveTypeJson.addLeaveTypeId){
			$scope.addLeaveTypeJson.companyLeavePlanId = $rootScope.companyLeavePlansId;
			}
		$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.AddLeaveTypeController+'/addLeaveType', $scope.addLeaveTypeJson).success(function(data) {
			$scope.addLeaveTypeJson = {};
			$rootScope.leaveType = {};
			$state.go("leave_plans");
		}).error(function() {
      	  console.error('Could not save or update jobtitles');
        });}
	};
          
	$scope.cancel = function(){
		$state.go("leave_plans");
	}

          
//init
        $scope.init = function(){
        	if($rootScope.leaveType){
        		$scope.addLeaveTypeJson = $rootScope.leaveType;
        	}else{
        	$scope.addLeaveTypeJson = {};
        	}
        }  
        $scope.init();
}]);
