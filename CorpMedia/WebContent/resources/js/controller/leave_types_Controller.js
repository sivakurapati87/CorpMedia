'use strict';

	App.controller('leave_types_Controller', ['$scope','$location','$rootScope','$http','$state', function($scope,$location,$rootScope,$http,$state) {

		 $scope.state="leave_types";
			$scope.left_state = "leaves_&_holidays";
			$scope.isProcessing = true;
		//Save leave type
		$scope.saveCompanyLeaveType = function(){
			$scope.isProcessing = true;
			if($rootScope.selectedCompanyObj){
				$scope.companyLeaveTypeJson.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.CompanyLeaveTypeController+'/saveCompanyLeaveType', $scope.companyLeaveTypeJson).success(function(data) {
				$scope.companyLeaveTypeJson = {};
				$scope.getAllCompanyLeaveTypeList();
				$scope.collapsed = true;
				$scope.isProcessing = false;
			}).error(function() {
	      	  console.error('Could not save or update jobtitles');
	        });}
		};
	          
		// get all company leave type
		$scope.getAllCompanyLeaveTypeList = function(){ 
			$scope.isProcessing = true;
			if($rootScope.selectedCompanyObj){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.CompanyLeaveTypeController+'/getAllCompanyLeaveTypeList/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
				$scope.companyLeaveTypeJsonList = data;
				$scope.isProcessing = false;
			}).error(function() {
	      	  console.error('Could not getAllCompanyLeaveTypeList');
	        });}
		};
	          
		
		// edit Leave Type
		$scope.editLeaveType = function(leaveType){
			$scope.companyLeaveTypeJson = leaveType;
			$scope.collapsed = false;
		};
		
		//delete Leave Type
		$scope.deleteLeaveType = function(companyLeaveTypeId){
			$scope.isProcessing = true;
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.CompanyLeaveTypeController+'/deleteCompanyLeaveType/'+ companyLeaveTypeId).success(function(data) {
				$scope.getAllCompanyLeaveTypeList();
				$scope.isProcessing = false;
			}).error(function() {
	      	  console.error('Could not deleteCompanyDepartment');
	        });
		};
		
		//This is to hide the bloc
		$scope.cancel = function(){
			$scope.collapsed = true;
		}
			//init
	        $scope.init = function(){
	        	$scope.companyLeaveTypeJson = {};
	        	$scope.getAllCompanyLeaveTypeList();
	        	$scope.collapsed = true;
	        };
	        $scope.init();
	}]);
