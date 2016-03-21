'use strict';

App.controller('All_Employee_Controller', ['$scope','$state','$rootScope','$http','$stateParams', function($scope,$state,$rootScope,$http,$stateParams) {

	$scope.state="all_employees";
	$scope.left_state = "employee";
	$scope.isProcessing = true;
	
		// get all the employees list
		$scope.getAllEmployeesList = function(){
			$scope.isProcessing = true;
			if($rootScope.selectedCompanyObj){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.EmployeeController+'/getAllEmployeesByCompanyId/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
				$scope.employeeJsonList = data;
				$scope.isProcessing = false;
			}).error(function() {
	      	  console.error('Could not get All Employees List');
	        });}
		};
		
		$scope.onClickNavigation = function(emp){
			$rootScope.empObj = emp;
			$state.go("employee_info");
		};
		
		//init callers
		$scope.getAllEmployeesList();
}]);
