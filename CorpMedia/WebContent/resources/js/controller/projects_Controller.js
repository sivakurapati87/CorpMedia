'use strict';

App.controller('projects_Controller', ['$scope','$location','$rootScope','$http','$stateParams', function($scope,$location,$rootScope,$http,$stateParams) {
	 var self = this;
	 $scope.state="projects";
		$scope.left_state = "project";
		$scope.projects = {};
		
		
		//This function is to save projects
		$scope.saveOrUpdateProjects = function(){
			if($scope.projectsJson.strStartDate){//converting the date format
				$scope.projectsJson.strStartDate = $scope.formatteddate($scope.projectsJson.strStartDate);
			}
			if($scope.projectsJson.strEndDate){//converting the date format
				$scope.projectsJson.strEndDate = $scope.formatteddate($scope.projectsJson.strEndDate);
			}
			if($rootScope.selectedCompanyObj){
				$scope.projectsJson.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.ProjectsController+'/saveOrUpdateProjects', $scope.projectsJson).success(function(data) {
			}).error(function() {
	      	  console.error('Could not save or update projects');
	        });}
		};

          

          
}]);
