'use strict';

App.controller('Company_Legalentities_Controller', ['$rootScope','$http','$scope','$location','CompanyInfoService','$stateParams', function($rootScope,$http,$scope,$location,CompanyInfoService,$stateParams) {
	$scope.state="legalentities";
	$scope.left_state = "company_settings";
	$scope.state_info_name = null;
	$scope.companyName= null;
	
	$scope.signator = {};
	
	$scope.companyBank = {};
	
	//save new signatory
	$scope.addNewSignatory = function(){
		if($rootScope.selectedCompanyObj){
			$scope.signator.companyId = $rootScope.selectedCompanyObj.companyId;
		$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.COMP_SIGNATOR+'/saveSignatory', $scope.signator).success(function(data) {
      	  if(data){
      		 $('#addSignatoryPopupId').modal('hide');
      		$scope.signator = {};
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
	
	
	//Save New Bank
	$scope.saveBank = function(){
		if($rootScope.selectedCompanyObj){
			$scope.companyBank.companyId = $rootScope.selectedCompanyObj.companyId;
		$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.CompanyBankController+'/saveBank', $scope.companyBank).success(function(data) {
      	  if(data){
      		 $('#addBankPopupId').modal('hide');
      		$scope.signator = {};
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
//			$scope.signator = data;
//			angular.element('#addSignatoryId').trigger('click');
			$scope.signatorsList = data;
		}).error(function() {
      	  console.error('Could not getAllRoles');
        });}
	};
	
	$scope.getAllSignatoriesList();
}]);
