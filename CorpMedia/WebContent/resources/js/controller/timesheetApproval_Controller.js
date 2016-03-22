'use strict';

App.controller('timesheetApproval_Controller', ['$scope','$state','$rootScope','$http', function($scope,$state,$rootScope,$http) {
	 	$scope.state="timesheetApproval";
	 	$scope.left_state = "time_And_attendance";
		$scope.employeeLeaveJson = {};
		$scope.comment = null;
		
		// get all company applied time sheet
		$scope.getAllAppliedTimesheetList = function(){
			if($rootScope.selectedCompanyObj){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.EmployeeTimeSheetController+'/getAllAppliedTimesheetList?companyId='+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
				$scope.empTimesheetMap = data;
			}).error(function() {
	      	  console.error('Could not getAllAppliedTimesheetList');
	        });}
		};
		
		//approve or reject applied leave
		$scope.approveOrRejectEmpTimeSheet = function(approveOrReject,employeeTimeSheetJsonList){
			if($rootScope.selectedCompanyObj){
				
				angular.forEach(employeeTimeSheetJsonList, function(obj, key){
					obj.comment = $scope.comment;
					obj.approveOrReject = approveOrReject;
		           	 });
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.EmployeeTimeSheetController+'/approveOrRejectEmpTimeSheet', employeeTimeSheetJsonList).success(function(data) {
				$scope.getAllAppliedTimesheetList();
			}).error(function() {
	      	  console.error('Could not approveOrRejectAppliedLeaves');
	        });}
		};
		
		//getting the length of the map
		$scope.getLength = function() {
		    return Object.keys($scope.empTimesheetMap).length;
		}
		//init
		$scope.getAllAppliedTimesheetList();
}]);
