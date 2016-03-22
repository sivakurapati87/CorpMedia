'use strict';

App.controller('timesheetApproval_Controller', ['$scope','$state','$rootScope','$http', function($scope,$state,$rootScope,$http) {
	 	$scope.state="timesheetApproval";
	 	$scope.left_state = "time_And_attendance";
		$scope.employeeLeaveJson = {};
		
		//Save Employee Leaves
		$scope.saveOrUpdateEmployeeLeaves = function(){
			if($rootScope.selectedCompanyObj){
				$scope.employeeLeaveJson.employeeId = $rootScope.empObj.employeeId;
				$scope.employeeLeaveJson.strLeaveStartDate = $scope.formatteddate($scope.employeeLeaveJson.strLeaveStartDate);
				$scope.employeeLeaveJson.strLeaveEndDate = $scope.formatteddate($scope.employeeLeaveJson.strLeaveEndDate);
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.EmployeeLeaveController+'/saveOrUpdateEmployeeLeaves', $scope.employeeLeaveJson).success(function(data) {
				$state.go("employee_timesheets");
			}).error(function() {
	      	  console.error('Could not save or update Employee Family Info');
	        });}
		};
		
		// get all company leave type
		$scope.getAllLeaveTypeListByCmpIdAndGenderId = function(){
			if($rootScope.selectedCompanyObj){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.CompanyLeaveTypeController+'/getAllLeaveTypeListByCmpIdAndGenderId?companyId='+ $rootScope.selectedCompanyObj.companyId+"&genderId="+$rootScope.empObj.genderId).success(function(data) {
				$scope.companyLeaveTypeJsonList = data;
			}).error(function() {
	      	  console.error('Could not getAllLeaveTypeListByCmpIdAndGenderId');
	        });}
		};
		
		// get all the projects assigned to an employee
		$scope.getEmployeeProjects = function(){
			if($rootScope.empObj){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.EmployeeController+'/getEmployeeProjects/'+  $rootScope.empObj.employeeId).success(function(data) {
				$scope.employeeProjectsList = data;
			}).error(function() {
	      	  console.error('Could not get Employee Projects');
	        });}
		};
		
		
		//init functions
//		$scope.getAllLeaveTypeListByCmpIdAndGenderId();
//		$scope.getEmployeeProjects();
		
		//This is to formate dates
		 $scope.formatteddate = function(date){
	      	  var expDate = new Date(date);
	      	 var month = '' + (expDate.getMonth() + 1);
	           var day = '' + expDate.getDate();
	          var  year = expDate.getFullYear();
	      	  if (month.length < 2) month = '0' + month;
	      	    if (day.length < 2) day = '0' + day;
	      	    return [year, month, day].join('-');
	       };
}]);
