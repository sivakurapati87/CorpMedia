'use strict';

App.controller('employee_projects_Controller', ['$scope','$location','$rootScope','$http','$stateParams', function($scope,$location,$rootScope,$http,$stateParams) {
	 	$scope.state="employee_projects";
		$scope.left_state = "employee";
		$scope.employeeProjectJson = {};
		
		
		//Save/update employee projects
		$scope.saveOrUpdateEmployeeProject = function(){
			if($rootScope.selectedCompanyObj){
				$scope.employeeProjectJson.companyId = $rootScope.selectedCompanyObj.companyId;
				$scope.employeeProjectJson.employeeId = $rootScope.empId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.EmployeeController+'/saveOrUpdateEmployeeProject', $scope.employeeProjectJson).success(function(data) {
				$scope.getEmployeeProjects();
				$scope.employeeProjectJson = {};
			}).error(function() {
	      	  console.error('Could not save or update Employee Project');
	        });}
		};
	        
		// get all the projects assigned to an employee
		$scope.getEmployeeProjects = function(){
			if($rootScope.empId){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.EmployeeController+'/getEmployeeProjects/'+  $rootScope.empId).success(function(data) {
				$scope.employeeProjectsList = data;
				if(!$scope.projectList){
				$scope.getAllProjectList();
				}else{
					$scope.getFinalProjectsList();
				}
			}).error(function() {
	      	  console.error('Could not get Employee Projects');
	        });}
		};
			
			// This function is to edit employee projects
			$scope.editEmployeeProject = function(employeeProjectJson){
				$scope.employeeProjectJson = employeeProjectJson;
				$scope.getFinalProjectsList();
				$scope.getEditModeProjectsList();
			};
			
			//delete Employee Project
			$scope.deleteEmployeeProject = function(employeeProjectId){
				$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.EmployeeController+'/deleteEmployeeProject/'+ employeeProjectId).success(function(data) {
					$scope.getEmployeeProjects();
				}).error(function() {
		      	  console.error('Could not deleteEmployee Family Info');
		        });
			};
			// get all Projects list
			$scope.getAllProjectList = function(){
				if($rootScope.selectedCompanyObj){
				$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.ProjectsController+'/getAllProjectList/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
					$scope.projectList = data;
					$scope.getFinalProjectsList();
				}).error(function() {
		      	  console.error('Could not getAllProjects List');
		        });}
			};
			
			//This function is to get all the roles
			$scope.getAllRoles = function(){
				if($rootScope.selectedCompanyObj){
				$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.CompanyRolesController+'/getAllRoles/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
					$scope.companyRolesJsonList = data;
				}).error(function() {
		      	  console.error('Could not getAllRoles');
		        });}
			};
			
			
			//Get the all projects List
			$scope.getFinalProjectsList = function(){
				$scope.finalProjectsList = [{}];
				$scope.finalProjectsList.splice(0,1);
						angular.forEach($scope.projectList, function(o, k)
	    				  {
							var flag=false;
							angular.forEach($scope.employeeProjectsList, function(obj, key)
		    				  {
								
								if(obj.projectId == o.projectId){
								flag = true;
								}
		    				  });
							if(!flag && $scope.finalProjectsList.indexOf(o) === -1){
								$scope.finalProjectsList.push(o);
							}
			           	  });
			};
			
			//Get the edit mode projects list
			$scope.getEditModeProjectsList = function(){
						angular.forEach($scope.projectList, function(o, k)
	    				  {
							if($scope.employeeProjectJson.projectId == o.projectId){
								$scope.finalProjectsList.push(o);
							}
			           	  });
			};
			
			//init functions
			
			$scope.getAllRoles();
			$scope.getEmployeeProjects();
}]);
