'use strict';

App.controller('applyLeave_Controller', ['$scope','$state','$rootScope','$http', function($scope,$state,$rootScope,$http) {
	 	$scope.state="employee_finance";
		$scope.left_state = "employee";
		$scope.employeeLeaveJson = {};
		$scope.isProcessing = true;
		
		//Save Employee Leaves
		$scope.saveOrUpdateEmployeeLeaves = function(){
			$scope.isProcessing = true;
			if($rootScope.selectedCompanyObj){
				$scope.employeeLeaveJson.employeeId = $rootScope.empObj.employeeId;
				if($scope.employeeLeaveJson.strLeaveStartDate){
				$scope.employeeLeaveJson.strLeaveStartDate = $scope.formatteddate($scope.employeeLeaveJson.strLeaveStartDate);
				}
				if($scope.employeeLeaveJson.strLeaveEndDate){
				$scope.employeeLeaveJson.strLeaveEndDate = $scope.formatteddate($scope.employeeLeaveJson.strLeaveEndDate);
				}
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.EmployeeLeaveController+'/saveOrUpdateEmployeeLeaves', $scope.employeeLeaveJson).success(function(data) {
				$state.go("employee_timesheets");
				$scope.isProcessing = false;
			}).error(function() {
	      	  console.error('Could not save or update Employee Family Info');
	        });}
		};
		
		// get all company leave type
		$scope.getAllLeaveTypeListByCmpIdAndGenderId = function(){
			$scope.isProcessing = true;
			if($rootScope.selectedCompanyObj){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.CompanyLeaveTypeController+'/getAllLeaveTypeListByCmpIdAndGenderId?companyId='+ $rootScope.selectedCompanyObj.companyId+"&genderId="+$rootScope.empObj.genderId).success(function(data) {
				$scope.companyLeaveTypeJsonList = data;
				$scope.isProcessing = false
			}).error(function() {
	      	  console.error('Could not getAllLeaveTypeListByCmpIdAndGenderId');
	        });}
		};
		
		// get all the projects assigned to an employee
		$scope.getEmployeeProjects = function(){
			if($rootScope.empObj){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.EmployeeController+'/getEmployeeProjects/'+  $rootScope.empObj.employeeId).success(function(data) {
				$scope.employeeProjectsList = data;
			}).error(function() {
	      	  console.error('Could not get Employee Projects');
	        });}
		};
		
		
		//init functions
		$scope.getAllLeaveTypeListByCmpIdAndGenderId();
		$scope.getEmployeeProjects();
		
		//This is to formate dates
		 $scope.formatteddate = function(date){
	      	  var expDate = new Date(date);
	      	 var month = '' + (expDate.getMonth() + 1);
	           var day = '' + expDate.getDate();
	          var  year = expDate.getFullYear();
	      	  if (month.length < 2) month = '0' + month;
	      	    if (day.length < 2) day = '0' + day;
	      	    return [year, month, day].join('-');
	       };
}]);
