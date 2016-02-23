'use strict';

App.controller('adhoc_components_Controller', ['$scope','$location','$rootScope','$http','$stateParams', function($scope,$location,$rootScope,$http,$stateParams) {
	 var self = this;
	 $scope.state="adhoc_components";
		$scope.left_state = "payroll";
		$scope.collapsed = false;
		$scope.deductions = {};
		$scope.reimbursement = {};
		$scope.bonuses = {};
		

		//Save deductions
		$scope.saveDeductions = function(){
			alert($rootScope.selectedCompanyObj.companyId);
			if($rootScope.selectedCompanyObj){
				$scope.deductions.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.DeductionsController+'/saveDeductions', $scope.deductions).success(function(data) {
	        }).error(function() {
	      	  console.error('Could not save or update deductions');
	        });}
		};
		
		//Save reimbursement
		$scope.saveReimbursement = function(){
			alert($rootScope.selectedCompanyObj.companyId);
			if($rootScope.selectedCompanyObj){
				$scope.reimbursement.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.ReimbursementController+'/saveReimbursement', $scope.reimbursement).success(function(data) {
	        }).error(function() {
	      	  console.error('Could not save or update reimbursement');
	        });}
		};
		
		//Save bonuses
		$scope.saveBonuses = function(){
			alert($rootScope.selectedCompanyObj.companyId);
			if($rootScope.selectedCompanyObj){
				$scope.bonuses.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.BonusesController+'/saveBonuses', $scope.bonuses).success(function(data) {
	        }).error(function() {
	      	  console.error('Could not save or update bonuses');
	        });}
		};
		
		//Save allowances
		$scope.saveAllowances = function(){
			alert($rootScope.selectedCompanyObj.companyId);
			if($rootScope.selectedCompanyObj){
				$scope.allowances.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.AllowancesController+'/saveAllowances', $scope.allowances).success(function(data) {
	        }).error(function() {
	      	  console.error('Could not save or update allowances');
	        });}
		};
		

		
		
		
		
          


          

          
}]);
