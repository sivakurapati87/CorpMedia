'use strict';

App.controller('leaveApproval_Controller', ['$scope','$state','$rootScope','$http', function($scope,$state,$rootScope,$http) {
	 	$scope.state="leaveApproval";
	 	$scope.left_state = "time_And_attendance";
		
		// get all company leave type
		$scope.getAllAppliedLeavesByCompany = function(){
			if($rootScope.selectedCompanyObj){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.EmployeeLeaveController+'/getAllAppliedLeavesByCompany?companyId='+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
				$scope.appliedLeavesList = data;
			}).error(function() {
	      	  console.error('Could not getAllAppliedLeavesByCompany');
	        });}
		};
		
		//approve or reject applied leave
		$scope.approveOrRejectAppliedLeaves = function(approveOrReject,employeeLeaveJson){
			if($rootScope.selectedCompanyObj){
				$scope.employeeLeaveJson = employeeLeaveJson;
				$scope.employeeLeaveJson.approveOrReject = approveOrReject;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.EmployeeLeaveController+'/approveOrRejectAppliedLeaves', $scope.employeeLeaveJson).success(function(data) {
				$scope.getAllAppliedLeavesByCompany();
				$scope.employeeLeaveJson = {};
			}).error(function() {
	      	  console.error('Could not approveOrRejectAppliedLeaves');
	        });}
		};
		
		//init
		$scope.getAllAppliedLeavesByCompany();
}]);
