'use strict';

App.controller('on_boarding_Controller', ['$scope','$location','$rootScope','$http','$stateParams', function($scope,$location,$rootScope,$http,$stateParams) {
	 var self = this;
	 $scope.state="on_boarding";
		$scope.left_state = "onboarding_&_exit";
		$scope.taskassigntohr = {};
		$scope.taskassigntoemployee = {};
		$scope.isProcessing = true;
		//Save  Task Assign to Hr
		$scope.saveTaskAssignToHr = function(){
			$scope.isProcessing = true;
			if($rootScope.selectedCompanyObj){
				$scope.taskassigntohr.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.TaskAssignToHrController+'/saveTaskAssignToHr', $scope.taskassigntohr).success(function(data) {
				$scope.getAllTaskAssignToHrList();
				$scope.taskassigntohr = {};
				$scope.isProcessing = false;
			}).error(function() {
	      	  console.error('Could not save or update taskassigntohr');
	        });}
		};
		
		
		// get Task Assign to Hr list
		$scope.getAllTaskAssignToHrList = function(){
			$scope.isProcessing = true;
			if($rootScope.selectedCompanyObj){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.TaskAssignToHrController+'/getAllTaskAssignToHrList/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
				$scope.taskAssignToHrList = data;
				$scope.isProcessing = false;
			}).error(function() {
	      	  console.error('Could not getAllTaskAssignToHrList');
	        });}
		};
		
		// init 
		
		$scope.getAllTaskAssignToHrList();
		
		//delete Task Assign to Hr
		$scope.deleteTaskAssignToHr = function(taskAssignToHrId){
			$scope.isProcessing = true;
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.TaskAssignToHrController+'/deleteTaskAssignToHr/'+ taskAssignToHrId).success(function(data) {
				$scope.getAllTaskAssignToHrList();
				$scope.isProcessing = false;
			}).error(function() {
	      	  console.error('Could not deleteTaskAssignToHr');
	        });
		};
		
		
		//Save  Task Assign to Employee
		$scope.saveTaskAssignToEmployee = function(){
			$scope.isProcessing = true;
			if($rootScope.selectedCompanyObj){
				$scope.taskassigntoemployee.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.TaskAssignToEmployeeController+'/saveTaskAssignToEmployee', $scope.taskassigntoemployee).success(function(data) {
				 $scope.getAllTaskAssignToEmployeeList();
				 $scope.taskassigntoemployee = {};
				 $scope.isProcessing = false;
			}).error(function() {
	      	  console.error('Could not save or update taskassigntoemployee');
	        });}
		};
		
		
		// get Task Assign to Employee list
		$scope.getAllTaskAssignToEmployeeList = function(){
			if($rootScope.selectedCompanyObj){
				$scope.isProcessing = true;
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.TaskAssignToEmployeeController+'/getAllTaskAssignToEmployeeList/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
				$scope.taskAssignToEmployeeList = data;
				$scope.isProcessing = false;
			}).error(function() {
	      	  console.error('Could not getAllTaskAssignToEmployeeList');
	        });}
		};
		
		// init 
		 $scope.getAllTaskAssignToEmployeeList();
		 

			//delete Task Assign to Employee
			$scope.deleteTaskAssignToEmployee = function(taskAssignToEmployeeId){
				$scope.isProcessing = true;
				$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.TaskAssignToEmployeeController+'/deleteTaskAssignToEmployee/'+ taskAssignToEmployeeId).success(function(data) {
					$scope.getAllTaskAssignToEmployeeList();
					$scope.isProcessing = false;
				}).error(function() {
		      	  console.error('Could not deleteTaskAssignToEmployee');
		        });
			};

          

          
}]);
