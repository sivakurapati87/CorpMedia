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
		
		$scope.init = function(){
			
			$scope.getAllDepartmentsList();
			$scope.deptWorkHours={};
			 $scope.getAllDeptWorkHoursList();
		};
		
		//init function
		$scope.init();
		
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
		
		// get all department Work Hrs list
		  $scope.getAllDeptWorkHoursList = function(){
		   if($rootScope.selectedCompanyObj){
		   $http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.DeptWorkHoursController+'/getAllDeptWorkHoursList/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
		    $scope.deptWorkHoursList = data;
		    
		   }).error(function() {
		          console.error('Could not get department Work Hours list');
		         });}
		  };
		  
		  // init
		 
		  
		  // edit department WorkHours
		  $scope.editDeptWorkHours = function(deptWHL ){
		   $scope.deptWorkHours = deptWHL;
		   $scope.isExpCollapse = false;
		  };
		  
		  //delete department Work Hour
		  $scope.deleteDeptWorkHours= function(deptWorkHourId){
		   $http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.DeptWorkHoursController+'/deleteDeptWorkHours/'+ deptWorkHourId).success(function(data) {
		    $scope.getAllDeptWorkHoursList();
		   }).error(function() {
		          console.error('Could not delete department work hours');
		         });
		  };    
}]);
