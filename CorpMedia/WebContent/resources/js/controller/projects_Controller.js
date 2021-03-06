'use strict';

App.controller('projects_Controller', ['$scope','$location','$rootScope','$http','$stateParams', function($scope,$location,$rootScope,$http,$stateParams) {
	 var self = this;
	 $scope.state="projects";
		$scope.left_state = "project";
		$scope.projects = {};
		$scope.isProcessing = true;
		
		
		// get all clients list
		$scope.getAllClientsList = function(){
			$scope.isProcessing = true;
			if($rootScope.selectedCompanyObj){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.ClientsController+'/getAllClientsList/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
				$scope.clientsList = data;
				$scope.isProcessing = false;
			}).error(function() {
	      	  console.error('Could not getclientsList');
	        });}
		};
		
		// init
		$scope.getAllClientsList();
		
		
		
		//This function is to save projects
		$scope.saveOrUpdateProjects = function(){
			$scope.isProcessing = true;
			if($rootScope.selectedCompanyObj){
				$scope.projects.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.ProjectsController+'/saveOrUpdateProject/',$scope.projects).success(function(data) {
				$scope.projects = {};
				$scope.getAllProjectsList();
				$scope.isProcessing = false;
				
			}).error(function() {
	      	  console.error('Could not Save Projects');
	        });}
		};
          
		// get all Projects list
		$scope.getAllProjectsList = function(){
			if($rootScope.selectedCompanyObj){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.ProjectsController+'/getAllProjectList/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
				$scope.projectsList = data;
			}).error(function() {
	      	  console.error('Could not getAllProjects List');
	        });}
		};
		//init functions
		$scope.getAllProjectsList();
		
		// edit project
		$scope.editProjects = function(projects ){
			$scope.projects = projects;
			$scope.isExpCollapse = false;
			$("#fade_out").fadeOut();
			$("#fade_in").fadeIn();
		};
		
		//delete  project
		$scope.deleteProjects= function(projectId){
			$scope.isProcessing = true;
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.ProjectsController+'/deleteProject/'+ projectId).success(function(data) {
				$scope.getAllProjectsList();
				$scope.isProcessing = false;
				
			}).error(function() {
	      	  console.error('Could not delete Project');
	        });
		};
		
		
		// cancel
		$scope.cancelProjects = function() {
			$scope.isExpCollapse = true;
		};



          
}]);
