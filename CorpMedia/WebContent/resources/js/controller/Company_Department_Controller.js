'use strict';

App.controller('Company_Department_Controller', ['$scope','$rootScope','$http', function($scope,$rootScope,$http) {
	$scope.state="department";
	$scope.left_state = "company_settings";
	$scope.collapsed = false;
	
	$scope.department = {};
	
	//Save New Bank
	$scope.saveDepartment = function(){
		if($rootScope.selectedCompanyObj){
			$scope.department.companyId = $rootScope.selectedCompanyObj.companyId;
		$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.DepartmentController+'/saveDepartment', $scope.department).success(function(data) {
        }).error(function() {
      	  console.error('Could not save or update addNewSignatory');
        });}
	};
	
}]);
