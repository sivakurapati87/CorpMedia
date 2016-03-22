'use strict';

App.controller('employeePaySlip_Controller', ['$scope','$state','$rootScope','$http', function($scope,$state,$rootScope,$http) {
	 	$scope.state="employeePaySlip";
	 	$scope.left_state = "employee";
	 	
		
		// get the employee Salary Info
		$scope.getEmployeeSalaryInfo = function(){
			if($rootScope.empObj){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.EmployeeController+'/getEmployeePayroll/'+  $rootScope.empObj.employeeId).success(function(data) {
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
