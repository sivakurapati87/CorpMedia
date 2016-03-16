'use strict';

App.controller('general_payroll_settings_Controller', ['$scope','$location','$rootScope','$http','$stateParams', function($scope,$location,$rootScope,$http,$stateParams) {
	 $scope.state="general_payroll_settings";
		$scope.left_state = "payroll";
		$scope.payrollcyclesettings = {};
		$scope.payrollperiodcalculation = {};
		
		
		
		
		
		
		//Save payrollcyclesettings
		$scope.savePayrollCycleSettings = function(){
			if($rootScope.selectedCompanyObj){
				$scope.payrollcyclesettings.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.PayrollCycleSettingsController+'/savePayrollCycleSettings', $scope.payrollcyclesettings).success(function(data) {
	        }).error(function() {
	      	  console.error('Could not save or update payrollcyclesettings');
	        });}
		};
		
		
//		//Save payrollperiodcalculation
//		$scope.savePayrollPeriodCalculation = function(){
//			alert($rootScope.selectedCompanyObj.companyId);
//			if($rootScope.selectedCompanyObj){
//				$scope.payrollperiodcalculation.companyId = $rootScope.selectedCompanyObj.companyId;
//			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.PayrollPeriodCalculationController+'/savePayrollPeriodCalculation', $scope.payrollperiodcalculation).success(function(data) {
//	        }).error(function() {
//	      	  console.error('Could not save or update payrollperiodcalculation');
//	        });}
//		};

		
		
		//get all Pay cycle list
		$scope.getPayCycleList = function(){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.LookUpController+'/getPayCycleList').success(function(data) {
			
				$scope.payCycleJsonList = data;
			
			}).error(function() {
	      	  console.error('Could not deleteCompanyDepartment');
	        });
		};
		
		//This function is to get the selected month name
		$scope.onChangePayCycleMonth = function(){
			angular.forEach($scope.payCycleJsonList, function(obj, key){
				if(obj.indexOfTheMonth == $scope.payrollcyclesettings.payCycleMonthId){
					$scope.selectedMonth = obj.description;
					$scope.payPeriodEndComboAction();
				}
	          });
		};
		
		//This function is to get the list of pay days
		$scope.payPeriodEndComboAction = function(){
			if($scope.payrollcyclesettings.strPayPeriodEndDayId && $scope.payrollcyclesettings.payCycleMonthId != null){
				var payPeriodEndDay = $scope.payrollcyclesettings.strPayPeriodEndDayId;
				if($scope.payrollcyclesettings.strPayPeriodEndDayId == constants.LastDayOfTheMonth){
					payPeriodEndDay = constants.MAXENDOF_DAY;
				}
				$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.LookUpController+'/findPayDay?payCycleMonth='+$scope.payrollcyclesettings.payCycleMonthId+'&payPeriodEnd='+payPeriodEndDay).success(function(data) {
					if(data){
					$scope.payDayList = data;
					$scope.payDayPeriod = $scope.payDayList[0].payDayPeriod;
					}
				}).error(function() {
		      	  console.error('Could not deleteCompanyDepartment');
		        });
			}
		};
		
        
          
       // get the company payroll cycle
  		$scope.getPayrollCycleSettingsJson = function(){
  			if($rootScope.selectedCompanyObj){
  			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.PayrollCycleSettingsController+'/getPayrollCycleSettingsJson/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
  				$scope.payrollcyclesettings = data;
  				$scope.getPayCycleList();
  				$scope.payPeriodEndComboAction();
  			}).error(function() {
  	      	  console.error('Could not getPayrollCycleSettingsJson');
  	        });}
  		};


  		$scope.getPayrollCycleSettingsJson();
  		
          
}]);
