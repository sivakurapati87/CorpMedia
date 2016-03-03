'use strict';

App.controller('adhoc_components_Controller', ['$scope','$location','$rootScope','$http','$stateParams', function($scope,$location,$rootScope,$http,$stateParams) {
	 var self = this;
	 $scope.state="adhoc_components";
		$scope.left_state = "payroll";
		$scope.deductions = {};
		$scope.reimbursement = {};
		$scope.bonuses = {};
		$scope.allowances = {};
		

		//Save deductions
		$scope.saveDeductions = function(){
			alert($rootScope.selectedCompanyObj.companyId);
			if($rootScope.selectedCompanyObj){
				$scope.deductions.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.DeductionsController+'/saveDeductions', $scope.deductions).success(function(data) {
				$scope.getAllDeductionsList();
				$scope.deductions ={};
	        }).error(function() {
	      	  console.error('Could not save or update deductions');
	        });}
		};
		
		// get deductions list
		$scope.getAllDeductionsList = function(){
			if($rootScope.selectedCompanyObj){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.DeductionsController+'/getAllDeductionsList/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
				$scope.deductionsList = data;
			}).error(function() {
	      	  console.error('Could not getAllDeductionsList');
	        });}
		};
		
		// init 
		$scope.getAllDeductionsList();
		
		// edit deductions
		$scope.editDeductions = function(deductions){
			$scope.deductions = deductions;
		};
		
		//delete deductions
		$scope.deleteDeductions = function(deductionId){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.DeductionsController+'/deleteDeductions/'+ deductionId).success(function(data) {
				$scope.getAllDeductionsList();
			}).error(function() {
	      	  console.error('Could not deleteDeductions');
	        });
		};
		
		//Save reimbursement
		$scope.saveReimbursement = function(){
			alert($rootScope.selectedCompanyObj.companyId);
			if($rootScope.selectedCompanyObj){
				$scope.reimbursement.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.ReimbursementController+'/saveReimbursement', $scope.reimbursement).success(function(data) {
				$scope.getAllReimbursementList();
				$scope.reimbursement = {};
	        }).error(function() {
	      	  console.error('Could not save or update reimbursement');
	        });}
		};
		
		// get reimbursement list
		$scope.getAllReimbursementList = function(){
			if($rootScope.selectedCompanyObj){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.ReimbursementController+'/getAllReimbursementList/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
				$scope.reimbursementList = data;
			}).error(function() {
	      	  console.error('Could not getAllReimbursementList');
	        });}
		};
		
		// init 
		$scope.getAllReimbursementList();
		
		// edit reimbursement
		$scope.editReimbursement = function(reimbursement){
			$scope.reimbursement = reimbursement;
		};
		
		//delete reimbursement
		$scope.deleteReimbursement = function(reimbursementId){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.ReimbursementController+'/deleteReimbursement/'+ reimbursementId).success(function(data) {
				$scope.getAllReimbursementList();
			}).error(function() {
	      	  console.error('Could not deleteDeductions');
	        });
		};
		
		
		//Save bonuses
		$scope.saveBonuses = function(){
			alert($rootScope.selectedCompanyObj.companyId);
			if($rootScope.selectedCompanyObj){
				$scope.bonuses.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.BonusesController+'/saveBonuses', $scope.bonuses).success(function(data) {
				$scope.getAllBonusesList();
				$scope.bonuses = {};
	        }).error(function() {
	      	  console.error('Could not save or update bonuses');
	        });}
		};
		
		// get bonuses list
		$scope.getAllBonusesList = function(){
			if($rootScope.selectedCompanyObj){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.BonusesController+'/getAllBonusesList/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
				$scope.bonusesList = data;
			}).error(function() {
	      	  console.error('Could not getAllBonusesList');
	        });}
		};
		
		// init 
		$scope.getAllBonusesList();
		
		// edit bonuses
		$scope.editBonuses = function(bonuses){
			$scope.bonuses = bonuses;
		};
		
		//delete bonuses
		$scope.deleteBonuses = function(bonusesId){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.BonusesController+'/deleteBonuses/'+ bonusesId).success(function(data) {
				$scope.getAllBonusesList();
			}).error(function() {
	      	  console.error('Could not deleteBonuses');
	        });
		};
		
		
		//Save allowances
		$scope.saveAllowances = function(){
			alert($rootScope.selectedCompanyObj.companyId);
			if($rootScope.selectedCompanyObj){
				$scope.allowances.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.AllowancesController+'/saveAllowances', $scope.allowances).success(function(data) {
				$scope.getAllAllowancesList();
				$scope.allowances = {};
	        }).error(function() {
	      	  console.error('Could not save or update allowances');
	        });}
		};
		
		// get allowances list
		$scope.getAllAllowancesList = function(){
			if($rootScope.selectedCompanyObj){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.AllowancesController+'/getAllAllowancesList/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
				$scope.allowancesList = data;
			}).error(function() {
	      	  console.error('Could not getAllAllowancesList');
	        });}
		};
		
		// init 
		$scope.getAllAllowancesList();
		
		// edit allowances
		$scope.editAllowances = function(allowances){
			$scope.allowances = allowances;
		};
		
		//delete allowances
		$scope.deleteAllowances = function(allowancesId){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.AllowancesController+'/deleteAllowances/'+ allowancesId).success(function(data) {
				$scope.getAllAllowancesList();
			}).error(function() {
	      	  console.error('Could not deleteAllowances');
	        });
		};
		
		

		
		
		
		
          


          

          
}]);
