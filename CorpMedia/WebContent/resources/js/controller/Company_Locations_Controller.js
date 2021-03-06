'use strict';

App.controller('Company_Locations_Controller', ['$scope','$http','$rootScope', function($scope,$http,$rootScope) {
	$scope.state="locations";
	$scope.left_state = "company_settings";
	$scope.companyLocationJson = {};
	$scope.isCollapse = true;
	$scope.isProcessing = true;
	
	//Save New Location
	$scope.saveLocation = function(){
		$scope.isProcessing = true;
		if($rootScope.selectedCompanyObj){
			$scope.companyLocationJson.companyId = $rootScope.selectedCompanyObj.companyId;
		$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.CompanyLocationController+'/saveLocation', $scope.companyLocationJson).success(function(data) {
			$scope.getAllLocationsList();
			$scope.companyLocationJson={};
			$scope.isProcessing = false;
		}).error(function() {
      	  console.error('Could not save or update saveDepartment');
        });}
	};
	
	// get all company locations list
	$scope.getAllLocationsList = function(){
		$scope.isProcessing = true;
		if($rootScope.selectedCompanyObj){
		$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.CompanyLocationController+'/getAllLocationList/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
			$scope.companyLocationsList = data;
			$scope.isProcessing =false;
		}).error(function() {
      	  console.error('Could not getAllBanksList');
        });}
	};
	
	// edit companylocation
	$scope.editCompanyLocation = function(location){
		$scope.companyLocationJson = location;
		$scope.isCollapse = false;
	};
	
	//delete companylocation
	$scope.deleteCompanyLocation = function(companyLocationId){
		$scope.isProcessing = true;
		$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.CompanyLocationController+'/deleteLocation/'+ companyLocationId).success(function(data) {
			$scope.getAllLocationsList();
			$scope.isProcessing = false;
		}).error(function() {
      	  console.error('Could not deleteCompanyLocation');
        });
	};
	
	//init functions
	$scope.getAllLocationsList();
	
	//cancel
	$scope.cancelCompanyLocation = function() {
		$scope.isCollapse = true;
	};
	
}]);
