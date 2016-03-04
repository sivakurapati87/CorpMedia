'use strict';

App.controller('job_titles_Controller', ['$scope','$location','$rootScope','$http','$stateParams', function($scope,$location,$rootScope,$http,$stateParams) {
	 var self = this;
	 $scope.state="job_titles";
		$scope.left_state = "employee";
		$scope.collapsed = false;
		$scope.jobtitles = {};
		$scope.isCollapse = true;
		
		//Save jobtitles
		$scope.saveJobTitles = function(){
			if($rootScope.selectedCompanyObj){
				$scope.jobtitles.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.JobTitlesController+'/saveJobTitles', $scope.jobtitles).success(function(data) {
				$scope.getAllJobTitlesList();
				$scope.jobtitles = {};
			}).error(function() {
	      	  console.error('Could not save or update jobtitles');
	        });}
		};
		
		// get all company locations list
		$scope.getAllJobTitlesList = function(){
			if($rootScope.selectedCompanyObj){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.JobTitlesController+'/getAllJobTitlesList/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
				$scope.jobtitlesList = data;
			}).error(function() {
	      	  console.error('Could not getAllDepartmentsList');
	        });}
		};
		
		// edit companylocation
		$scope.editJobTitle = function(jobtitles){
			$scope.jobtitles = jobtitles;
			$scope.isCollapse = false;
		};
		
		//delete companylocation
		$scope.deleteJobTitle = function(jobTitleId){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.JobTitlesController+'/deleteJobTitle/'+ jobTitleId).success(function(data) {
				$scope.getAllJobTitlesList();
			}).error(function() {
	      	  console.error('Could not deleteCompanyDepartment');
	        });
		};
		
		//init functions
		$scope.getAllJobTitlesList();
		
		// cancel
		$scope.cancelJobTitle = function() {
			$scope.isCollapse = true;
		};
}]);
