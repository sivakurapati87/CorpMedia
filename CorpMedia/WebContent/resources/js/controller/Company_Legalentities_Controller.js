'use strict';

App.controller('Company_Legalentities_Controller', ['$rootScope','$http','$scope','$location','CompanyInfoService','$stateParams', function($rootScope,$http,$scope,$location,CompanyInfoService,$stateParams) {
	$scope.state="legalentities";
	$scope.left_state = "company_settings";
	$scope.state_info_name = null;
//	$scope.companyName= null;
	
	$scope.signator = {};
	
	$scope.companyBank = {};
	
	/*********************************** Signatory Related ********************************/
	
	//save new signatory
	$scope.addNewSignatory = function(){
		if($rootScope.selectedCompanyObj){
			$scope.signator.companyId = $rootScope.selectedCompanyObj.companyId;
		$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.COMP_SIGNATOR+'/saveSignatory', $scope.signator).success(function(data) {
      	  if(data){
      		 $('#addSignatoryPopupId').modal('hide');
      		$scope.signator = {};
      		$scope.getAllSignatoriesList();
      	  }else{
      		  //This is to display the error message
//      		  angular.element('#erroPopupId').trigger('click');
      	  }
        }).error(function() {
      	  console.error('Could not save or update addNewSignatory');
        });}
	};
	
	// get all signatories
	$scope.getAllSignatoriesList = function(){
		if($rootScope.selectedCompanyObj){
		$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.COMP_SIGNATOR+'/getAllSignatoriesList/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
//			$scope.signator = data;
//			angular.element('#addSignatoryId').trigger('click');
			$scope.signatorsList = data;
		}).error(function() {
      	  console.error('Could not getAllRoles');
        });}
	};
	
	// edit Signator
	$scope.editSignator = function(signtor){
		$scope.signator = signtor;
	};
	
	//delete Signator
	$scope.deleteSignator = function(companySignatorId){
		$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.COMP_SIGNATOR+'/deleteSignator/'+ companySignatorId).success(function(data) {
			$scope.getAllSignatoriesList();
		}).error(function() {
      	  console.error('Could not deleteBank');
        });
	};
	
	
	/*********************************** Bank Related ********************************/
	
	//Save New Bank
	$scope.saveBank = function(){
		if($rootScope.selectedCompanyObj){
			$scope.companyBank.companyId = $rootScope.selectedCompanyObj.companyId;
		$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.CompanyBankController+'/saveBank', $scope.companyBank).success(function(data) {
      	  if(data){
      		 $('#addBankPopupId').modal('hide');
      		$scope.companyBank = {};
      		$scope.getAllBanksList();
      	  }else{
      		  //This is to display the error message
//      		  angular.element('#erroPopupId').trigger('click');
      	  }
        }).error(function() {
      	  console.error('Could not save or update addNewSignatory');
        });}
	};
	
	// get all banks list
	$scope.getAllBanksList = function(){
		if($rootScope.selectedCompanyObj){
		$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.CompanyBankController+'/getAllSignatoriesList/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
			$scope.companyBanksList = data;
		}).error(function() {
      	  console.error('Could not getAllBanksList');
        });}
	};
	
	// edit bank
	$scope.editBank = function(bank){
		$scope.companyBank = bank;
	};
	
	//delete bank
	$scope.deleteBank = function(companyBankId){
		$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.CompanyBankController+'/deleteBank/'+ companyBankId).success(function(data) {
			$scope.getAllBanksList();
		}).error(function() {
      	  console.error('Could not deleteBank');
        });
	};
	
	//init methods
	$scope.getAllSignatoriesList();
	$scope.getAllBanksList();
}]);
