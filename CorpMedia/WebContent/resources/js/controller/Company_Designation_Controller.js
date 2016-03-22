'use strict';

App.controller('Company_Designation_Controller', ['$scope','$rootScope','$http', function($scope,$rootScope,$http) {
	$scope.state="designation";
	$scope.left_state = "company_settings";
	$scope.designation = {};
	$scope.isProcessing = true;
	$scope.isCollapse = true;
	
	//Save New Designation
	$scope.saveDesignation = function(){
		$scope.isProcessing = true;
		if($rootScope.selectedCompanyObj){
			$scope.designation.companyId = $rootScope.selectedCompanyObj.companyId;
		$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.DesignationController+'/saveDesignation', $scope.designation).success(function(data) {
			$scope.getAllDesignationsList();
			$scope.designation = {};
			$scope.isProcessing = false;
		}).error(function() {
      	  console.error('Could not save or update add Designation');
        });}
	};
	
	$scope.getAllDesignationsList = function(){
		$scope.isProcessing = true;
		if($rootScope.selectedCompanyObj){
		$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.DesignationController+'/getAllDesignationsList/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
			$scope.companyDesignationList = data;
			$scope.isProcessing = false;
		}).error(function() {
      	  console.error('Could not getAllDesignationsList');
        });}
	};
	
	// edit designation
	$scope.editCompanyDesignation = function(designation){
		$scope.designation = designation;
		$scope.isCollapse = false;
	};
	
	//delete Designation
	$scope.deleteCompanyDesignation = function(designationId){
		$scope.isProcessing = true;
		$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.DesignationController+'/deleteCompanyDesignation/'+ designationId).success(function(data) {
			$scope.getAllDesignationsList();
			$scope.isProcessing =false;
		}).error(function() {
      	  console.error('Could not deleteCompanyDesignation');
        });
	};
	
	//init functions
	$scope.getAllDesignationsList();
	
	
	//cancel
	
	$scope.cancelCompanyDesignation = function() {
		$scope.isCollapse = true;
	};
	
}]);
