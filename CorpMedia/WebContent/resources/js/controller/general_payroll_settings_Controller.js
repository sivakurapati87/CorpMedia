'use strict';

App.controller('general_payroll_settings_Controller', ['$scope','$location','$rootScope','$http','$stateParams', function($scope,$location,$rootScope,$http,$stateParams) {
	 var self = this;
	 $scope.state="general_payroll_settings";
		$scope.left_state = "payroll";
		$scope.payrollcyclesettings = {};
		$scope.payrollperiodcalculation = {};
		
		
		
		
		
		
		//Save payrollcyclesettings
		$scope.savePayrollCycleSettings = function(){
			alert($rootScope.selectedCompanyObj.companyId);
			if($rootScope.selectedCompanyObj){
				$scope.payrollcyclesettings.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.PayrollCycleSettingsController+'/savePayrollCycleSettings', $scope.payrollcyclesettings).success(function(data) {
	        }).error(function() {
	      	  console.error('Could not save or update payrollcyclesettings');
	        });}
		};
		
		
		//Save payrollperiodcalculation
		$scope.savePayrollPeriodCalculation = function(){
			alert($rootScope.selectedCompanyObj.companyId);
			if($rootScope.selectedCompanyObj){
				$scope.payrollperiodcalculation.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.PayrollPeriodCalculationController+'/savePayrollPeriodCalculation', $scope.payrollperiodcalculation).success(function(data) {
	        }).error(function() {
	      	  console.error('Could not save or update payrollperiodcalculation');
	        });}
		};

		
		
		
		
		
          


          

          
}]);
