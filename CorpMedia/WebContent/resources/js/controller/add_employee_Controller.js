'use strict';

App.controller('add_employee_Controller', ['$scope','$location','$rootScope','$http','$stateParams', function($scope,$location,$rootScope,$http,$stateParams) {
	 var self = this;
	 $scope.state="add_employee";
		$scope.left_state = "employee";
		
		$scope.employeeJson = {};
		$scope.isEmpCollapse = true;
		$scope.isProcessing = true;
		
		//Save/update employee
		$scope.saveOrUpdateEmployee = function(){
			$scope.isProcessing = true;
			$scope.formatteddate();
			if($rootScope.selectedCompanyObj){
				$scope.employeeJson.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.EmployeeController+'/saveOrUpdateEmployee', $scope.employeeJson).success(function(data) {
				$scope.employeeJson = {};
				$scope.getAllEmployeesList();
				$scope.isProcessing = false;
			}).error(function() {
	      	  console.error('Could not save or update Employee');
	        });}
		};
		// get all the employees list
		$scope.getAllEmployeesList = function(){
			$scope.isProcessing = true;
			if($rootScope.selectedCompanyObj){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.EmployeeController+'/getAllEmployeesByCompanyId/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
				$scope.employeeJsonList = data;
				$scope.getAllRoles();    
				$scope.getAllCompanyLocations();
				$scope.getAllDesignationsList();
				$scope.isProcessing = false;
			}).error(function() {
	      	  console.error('Could not get All Employees List');
	        });}
		};
		

		// get all the roles based on company id
		$scope.getAllRoles = function(){
			if($rootScope.selectedCompanyObj){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.CompanyRolesController+'/getAllRoles/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
				$scope.companyRolesJsonList = data;//all the roles of the company
			}).error(function() {
	      	  console.error('Could not getAllRoles');
	        });}
		};
		
		// get all the locations based on company id
		$scope.getAllCompanyLocations = function(){
			if($rootScope.selectedCompanyObj){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.CompanyLocationController+'/getAllLocationList/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
				$scope.companyLocations = data;//all the location of the company
			}).error(function() {
	      	  console.error('Could not getAllRoles');
	        });}
		};
		
		 //This is the function to get the formatted date
        $scope.formatteddate = function(){
      	  var expDate = new Date($scope.employeeJson.strDateOfJoining);
      	 var month = '' + (expDate.getMonth() + 1);
           var day = '' + expDate.getDate();
          var  year = expDate.getFullYear();
      	  if (month.length < 2) month = '0' + month;
      	    if (day.length < 2) day = '0' + day;
      	    $scope.employeeJson.strDateOfJoining =  [year, month, day].join('-');
        };
		
		
		
		// This function is to edit employee information
		$scope.editEmployee = function(employeeJson){
			$scope.employeeJson = employeeJson;
			var parts =$scope.employeeJson.strDateOfJoining.split('-');
			$scope.employeeJson.strDateOfJoining = new Date(parts[0],parts[1]-1,parts[2]); 
			$scope.isEmpCollapse = false;
		};
		
		// delete employee  information
		
		$scope.deleteEmployee = function(employeeId){
			$scope.isProcessing = true;
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.EmployeeController+'/deleteEmployee/'+ employeeId).success(function(data) {
				$scope.getAllEmployeesList();
				$scope.isProcessing = false;
			}).error(function() {
	      	  console.error('Could not deleteEmployee');
	        });
		};
		
		// cancel employee educational information
		$scope.cancelEmployee = function() {
			$scope.isEmpCollapse = true;
		};
		
		$scope.getAllDesignationsList = function(){
			if($rootScope.selectedCompanyObj){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.DesignationController+'/getAllDesignationsList/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
				$scope.companyDesignationList = data;
			}).error(function() {
	      	  console.error('Could not getAllDesignationsList');
	        });}
		};
		
		$scope.getAllEmployeesList();
}]);
