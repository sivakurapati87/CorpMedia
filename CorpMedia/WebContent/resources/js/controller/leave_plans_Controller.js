'use strict';

App.controller('leave_plans_Controller', ['$scope','$state','$rootScope','$http', function($scope,$state,$rootScope,$http) {
	 var self = this;
	 $scope.state="leave_plans";
		$scope.left_state = "leaves_&_holidays";
		$scope.isProcessing = true;
		
		//Navigate to add leave type
		$scope.addLeaveType=function(leavePlan,companyLeavePlansId){
			$rootScope.companyLeavePlansId = companyLeavePlansId;
			$scope.getCompanyLeaveType(leavePlan);
			$state.go('add_leave_types');
		};
		
		// edit Leave Type
		$scope.editLeaveType = function(leaveType,leavePlan){
			$rootScope.companyRemainingLeaveTypesList = $scope.companyLeaveTypeJsonList;
			$rootScope.leaveType = leaveType;
			$state.go('add_leave_types');
		};
		
		//Get the company leave types list
		$scope.getCompanyLeaveType = function(leavePlan){
			$rootScope.companyRemainingLeaveTypesList = [{}];
			$rootScope.companyRemainingLeaveTypesList.splice(0,1);
					angular.forEach($scope.companyLeaveTypeJsonList, function(o, k)
    				  {
						var flag=false;
						angular.forEach(leavePlan.leaveTypeJsonList, function(obj, key)
	    				  {
							if(obj.leaveTypeId == o.companyLeaveTypeId){
							flag = true;
							}
	    				  });
						if(!flag && $rootScope.companyRemainingLeaveTypesList.indexOf(o) === -1){
							$rootScope.companyRemainingLeaveTypesList.push(o);
						}
		           	     });
			
		};
		
		$scope.leavePlan = {};

		//Save leave plan
		$scope.saveLeavePlan = function(){
			$scope.isProcessing = true;
			if($rootScope.selectedCompanyObj){
				$scope.leavePlan.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.CompanyLeavePlanController+'/saveCompanyLeavePlans', $scope.leavePlan).success(function(data) {
				$scope.getAllLeavePlans();
				$scope.leavePlan = {};
				$scope.isProcessing = false;
			}).error(function() {
	      	  console.error('Could not save or update Leave Plan');
	        });}
		};
		
		// get all company Leave Plans list
		$scope.getAllLeavePlans = function(){
			$scope.isProcessing = true;
			if($rootScope.selectedCompanyObj){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.CompanyLeavePlanController+'/getAllCompanyLeavePlansList/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
				$scope.companyLeavePlansList = data;
				$scope.isProcessing = false;
			}).error(function() {
	      	  console.error('Could not getAllLeavePlans');
	        });}
		};
		
		// get all company leave type
		$scope.getAllCompanyLeaveTypeList = function(){
			$scope.isProcessing = true;
			if($rootScope.selectedCompanyObj){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.CompanyLeaveTypeController+'/getAllCompanyLeaveTypeList/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
				$scope.companyLeaveTypeJsonList = data;
				$scope.isProcessing = false;
			}).error(function() {
	      	  console.error('Could not getAllCompanyLeaveTypeList');
	        });}
		};
	          
		
		// edit Leave plan
		$scope.editJobTitle = function(leavePlan){
			$scope.leavePlan = leavePlan;
			$scope.isCollapse = false;
		};
		
		//delete companylocation
		$scope.deleteCompanyLeavePlans = function(leavePlanId){
			$scope.isProcessing = true;
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.CompanyLeavePlanController+'/deleteCompanyLeavePlans/'+ leavePlanId).success(function(data) {
				$scope.getAllLeavePlans();
				$scope.isProcessing = false;
			}).error(function() {
	      	  console.error('Could not deleteCompanyDepartment');
	        });
		};
		
		//init functions
		$scope.getAllLeavePlans();
		$scope.getAllCompanyLeaveTypeList();
		
		// cancel
		$scope.cancelJobTitle = function() {
			$scope.isCollapse = true;
		};
		
		
		
          


          

          
}]);
