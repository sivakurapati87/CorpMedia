'use strict';

App.controller('employeePaySlip_Controller', ['$scope','$state','$rootScope','$http', function($scope,$state,$rootScope,$http) {
	 	$scope.state="employeePaySlip";
	 	$scope.left_state = "employee";
	 	$scope.isComponentRequired = false;
	 	
		
		// get all company applied leaves
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
		
		// get the employee Salary Info
		$scope.getEmployeeSalaryInfo = function(){
			if($rootScope.empObj){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.EmployeeController+'/getEmployeeSalaryInfo/'+  $rootScope.empObj.employeeId).success(function(data) {
				$scope.employeeSalaryInfoJson = data;
			}).error(function() {
	      	  console.error('Could not get Employee Salary Info');
	        });}
		};
		
		// This function is to find the value of monthly
		$scope.findMonthlyAmount = function(amount){
			return Math.round(amount/12);
		}
		
		$scope.init = function(){
			 $scope.isProcessing = true;
			 $scope.getEmployeeSalaryInfo();
			 $scope.isProcessing = false;
		 }
		
		
		//init
		 $scope.init();
}]);
