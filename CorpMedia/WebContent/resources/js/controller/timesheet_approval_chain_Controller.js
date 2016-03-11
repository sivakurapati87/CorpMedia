'use strict';

App.controller('timesheet_approval_chain_Controller', ['$scope','$location','$rootScope','$http','$stateParams', function($scope,$location,$rootScope,$http,$stateParams) {
	 var self = this;
	 $scope.state="timesheet_approval_chain";
		$scope.left_state = "timesheet";
		$scope.TimeSheetApproverJsonList = null;
		
		$scope.isProcessing = true;
		
		//increase the approvers list
		$scope.addApproverLevel = function(){
			//If list is empty
			if(!$scope.TimeSheetApproverJsonList){
			$scope.TimeSheetApproverJsonList = [{}];
			}else{
				$scope.TimeSheetApproverJsonList.push({});
			}
		};
		
		// get all the roles based on company id
		$scope.getAllRoles = function(){
			if($rootScope.selectedCompanyObj){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.CompanyRolesController+'/getAllRoles/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
				$scope.companyRolesJsonList = data;//all the roles of the company
			}).error(function() {
	      	  console.error('Could not getAllRoles');
	        });}
		};
		
		//Save Approvers list
		$scope.saveOrUpdateApproversList = function(){
			if($rootScope.selectedCompanyObj){
				angular.forEach($scope.TimeSheetApproverJsonList, function(obj, key){
					obj.companyId = $rootScope.selectedCompanyObj.companyId;
		           	 });
				
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.TimeSheetApproverChainController+'/saveOrUpdateApprover', $scope.TimeSheetApproverJsonList).success(function(data) {
				$scope.getAllApproversList();
			}).error(function() {
	      	  console.error('Could not getAllRoles');
	        });}
		};
          
		// get all the approvers list
		$scope.getAllApproversList = function(){
			$scope.isProcessing = true;
			if(!$scope.companyRolesJsonList){
				$scope.getAllRoles();
				$scope.getAllEmployeesList();
			}
			if($rootScope.selectedCompanyObj){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.TimeSheetApproverChainController+'/getAllApproversList/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
				$scope.TimeSheetApproverJsonList = data;
				angular.forEach($scope.TimeSheetApproverJsonList, function(obj, key)
		  				  {
							obj.employeeJsonList = $scope.onChangeRoleAction(obj.roleId, obj);
		  				  });
				$scope.isProcessing = false;
			}).error(function() {
	      	  console.error('Could not getAllRoles');
	        });}
		};
		
		//On change role id
		$scope.onChangeRoleAction = function(roleId,approver){
			$scope.empList = [{}];
			$scope.empList.splice(0,1);
			angular.forEach($scope.EmployeeJsonList, function(obj, key)
  				  {
						if(obj.roleId == roleId){
							$scope.empList.push(obj);
						}
  				  });
			approver.employeeJsonList = $scope.empList;
			angular.forEach($scope.TimeSheetApproverJsonList, function(obj, key)
	  				  {
							if(obj.timeSheetApproverId == approver.timeSheetApproverId){
								obj = approver;
							}
	  				  });
			return $scope.empList;
		};
		
		// get all the Employees list
		$scope.getAllEmployeesList = function(){
			if($rootScope.selectedCompanyObj){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.EmployeeController+'/getAllEmployeesByCompanyId/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
				$scope.EmployeeJsonList = data;
			}).error(function() {
	      	  console.error('Could not get All Employees List');
	        });}
		};

		$scope.getAllApproversList();
		

          
}]);

