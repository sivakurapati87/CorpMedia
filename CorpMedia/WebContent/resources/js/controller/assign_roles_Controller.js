'use strict';

App.controller('assign_roles_Controller', ['$scope','$location','$rootScope','$http','$stateParams', function($scope,$location,$rootScope,$http,$stateParams) {
	 var self = this;
	 $scope.state="assign_roles";
		$scope.left_state = "roles_&_permissions";
		$scope.companyRolesJson = {};
		$scope.isProcessing = true;
		
		//Save New Role
		$scope.saveOrUpdateRole = function(){
			$scope.isProcessing = true;
			if($rootScope.selectedCompanyObj){
				$scope.companyRolesJson.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.CompanyRolesController+'/saveOrUpdateRole', $scope.companyRolesJson).success(function(data) {
				$scope.getAllRoles();
				$scope.companyRolesJson = {};
				$scope.isProcessing = false;
			}).error(function() {
	      	  console.error('Could not save or update saveRole');
	        });}
		};

		//This method is to edit the role
		$scope.editRole = function(role){
			$scope.companyRolesJson = role;
		};
		
		//This method is to get all the roles
		$scope.getAllRoles = function(){
			$scope.isProcessing = true;
			if($rootScope.selectedCompanyObj){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.CompanyRolesController+'/getAllRoles/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
				$scope.companyRolesJsonList = data;
				$scope.isProcessing =false;
			}).error(function() {
	      	  console.error('Could not getAllRoles');
	        });}
		};
		$scope.getAllRoles();
}]);
