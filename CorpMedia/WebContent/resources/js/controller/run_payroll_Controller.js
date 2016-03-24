'use strict';

App.controller('run_payroll_Controller', ['$scope','$location','$rootScope','$http','$stateParams', function($scope,$location,$rootScope,$http,$stateParams) {
	 $scope.state="run_payroll";
		$scope.left_state = "payroll";
		$scope.isProcessing = true;
		$scope.isDisabled = true;
		
		//get all employee salary info
		$scope.viewEmployeesPayRollByCompanyId = function(){
			$scope.isProcessing = true;
			if($scope.payrollcyclesettingsJson){
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.RunPayRollController+'/viewEmployeesPayRollByCompanyId', $scope.payrollcyclesettingsJson).success(function(data) {
				$scope.employeeSalaryInfoJsonList = data;
				$scope.isDisabled = false;
				$scope.isProcessing = false;
			}).error(function() {
	      	  console.error('Could not viewEmployeesPayRollByCompanyId');
	        });}
		};
		
		
		// This function is to find the value of monthly
		$scope.findMonthlyAmount = function(amount){
			return Math.round(amount/12);
		}
		
		
		 // get the company payroll cycle
  		$scope.getPayrollCycleSettingsJson = function(){
  			$scope.isProcessing = true;
  			if($rootScope.selectedCompanyObj){
  			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.PayrollCycleSettingsController+'/getPayrollCycleSettingsJson/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
  				$scope.payrollcyclesettingsJson = data;
  			}).error(function() {
  	      	  console.error('Could not getPayrollCycleSettingsJson');
  	        });}
  		};
		
  		//init
  		$scope.getPayrollCycleSettingsJson();
  		
          
}]);
