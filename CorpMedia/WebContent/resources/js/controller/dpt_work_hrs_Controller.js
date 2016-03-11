'use strict';

App.controller('dpt_work_hrs_Controller', ['$scope','$location','$rootScope','$http','$stateParams', function($scope,$location,$rootScope,$http,$stateParams) {
	 var self = this;
	 $scope.state="dpt_work_hrs";
		$scope.left_state = "project";
//		
		
		// get all company Departments list
		$scope.getAllDepartmentsList = function(){
			if($rootScope.selectedCompanyObj){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.DepartmentController+'/getAllDepartmentsList/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
				$scope.companyDepartmentList = data;
			}).error(function() {
	      	  console.error('Could not getAllDepartmentsList');
	        });}
		};
		//init functions
		$scope.getAllDepartmentsList();
		
		
		
		$scope.deptWorkHours={};
		//to save Department work hours 
		$scope.saveDeptWorkHours = function(){
			
			if($rootScope.selectedCompanyObj){
				$scope.deptWorkHours.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.DeptWorkHoursController+'/saveDeptWorkHours/',$scope.deptWorkHours).success(function(data) {
				$scope.getAllDepartmentsList();
				$scope.deptWorkHours={};
			}).error(function() {
	      	  console.error('could not svae DeptWorkHours');
	        });}
		};
		
		
		
		
		
		
		
          


          

          
}]);
