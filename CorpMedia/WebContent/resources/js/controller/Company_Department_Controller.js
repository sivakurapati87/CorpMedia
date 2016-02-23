'use strict';

App.controller('Company_Department_Controller', ['$scope','$rootScope','$http', function($scope,$rootScope,$http) {
	$scope.state="department";
	$scope.left_state = "company_settings";
	$scope.isCollapse = true;
	
	$scope.department = {};
	
	//Save New Department
	$scope.saveDepartment = function(){
		if($rootScope.selectedCompanyObj){
			$scope.department.companyId = $rootScope.selectedCompanyObj.companyId;
		$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.DepartmentController+'/saveDepartment', $scope.department).success(function(data) {
			$scope.getAllDepartmentsList();
			$scope.department = {};
		}).error(function() {
      	  console.error('Could not save or update addNewSignatory');
        });}
	};
	
	// get all company locations list
	$scope.getAllDepartmentsList = function(){
		if($rootScope.selectedCompanyObj){
		$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.DepartmentController+'/getAllDepartmentsList/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
			$scope.companyDepartmentList = data;
		}).error(function() {
      	  console.error('Could not getAllDepartmentsList');
        });}
	};
	
	// edit companylocation
	$scope.editCompanyDepartment = function(department){
		$scope.department = department;
		$scope.isCollapse = false;
	};
	
	//delete companylocation
	$scope.deleteCompanyDepartment = function(departmentId){
		$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.DepartmentController+'/deleteCompanyDepartment/'+ departmentId).success(function(data) {
			$scope.getAllDepartmentsList();
		}).error(function() {
      	  console.error('Could not deleteCompanyDepartment');
        });
	};
	
	//init functions
	$scope.getAllDepartmentsList();
	
	
	//cancel
	
	$scope.cancelCompanyDepartment = function() {
		$scope.isCollapse = true;
	};
	
}]);
