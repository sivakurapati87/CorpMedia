'use strict';

App.controller('employee_defaults_Controller', ['$scope','$location','$rootScope','$http','$stateParams', function($scope,$location,$rootScope,$http,$stateParams) {
	 var self = this;
	 $scope.state="employee_defaults";
		$scope.left_state = "employee";
		$scope.isCollapse = true;

		$scope.companyEmployeeDefaultsJson = {};
		
		
		//Save New Department
		$scope.saveCompanyEmpDefault = function(){
			if($rootScope.selectedCompanyObj){
				$scope.companyEmployeeDefaultsJson.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.CompanyEmpDefaultController+'/saveCompanyEmpDefault', $scope.companyEmployeeDefaultsJson).success(function(data) {
				$scope.companyEmployeeDefaultsJson = {};
				$scope.getCompanyEmpDefault();
				$scope.isCollapse = true;
			}).error(function() {
	      	  console.error('Could not save or update addNewSignatory');
	        });}
		};
		
		$scope.cancel = function(){
			$scope.isCollapse = true;
		}
		
		// get all company locations list
		$scope.getCompanyEmpDefault = function(){
			if($rootScope.selectedCompanyObj){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.CompanyEmpDefaultController+'/getCompanyEmpDefault/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
				$scope.companyEmployeeDefaultsJson = data;
			}).error(function() {
	      	  console.error('Could not getAllDepartmentsList');
	        });}
		};
		$scope.getCompanyEmpDefault();
}]);
