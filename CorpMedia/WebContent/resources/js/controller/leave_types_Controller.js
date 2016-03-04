'use strict';

	App.controller('leave_types_Controller', ['$scope','$location','$rootScope','$http','$state', function($scope,$location,$rootScope,$http,$state) {

		 $scope.state="leave_types";
			$scope.left_state = "leaves_&_holidays";
			
		//Save leave type
		$scope.saveCompanyLeaveType = function(){
			if($rootScope.selectedCompanyObj){
				$scope.companyLeaveTypeJson.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.CompanyLeaveTypeController+'/saveCompanyLeaveType', $scope.companyLeaveTypeJson).success(function(data) {
				$scope.companyLeaveTypeJson = {};
				$scope.getAllCompanyLeaveTypeList();
			}).error(function() {
	      	  console.error('Could not save or update jobtitles');
	        });}
		};
	          
		// get all company leave type
		$scope.getAllCompanyLeaveTypeList = function(){
			if($rootScope.selectedCompanyObj){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.CompanyLeaveTypeController+'/getAllCompanyLeaveTypeList/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
				$scope.companyLeaveTypeJsonList = data;
			}).error(function() {
	      	  console.error('Could not getAllCompanyLeaveTypeList');
	        });}
		};
	          
		
		// edit companylocation
		$scope.editLeaveType = function(leaveType){
			$scope.companyLeaveTypeJson = leaveType;
		};
		
		//delete companylocation
		$scope.deleteLeaveType = function(companyLeaveTypeId){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.CompanyLeaveTypeController+'/deleteCompanyLeaveType/'+ companyLeaveTypeId).success(function(data) {
				$scope.getAllCompanyLeaveTypeList();
			}).error(function() {
	      	  console.error('Could not deleteCompanyDepartment');
	        });
		};
		
			//init
	        $scope.init = function(){
	        	$scope.companyLeaveTypeJson = {};
	        	$scope.getAllCompanyLeaveTypeList();
	        };
	        $scope.init();
	}]);
