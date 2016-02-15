'use strict';

App.controller('Company_Department_Controller', ['$scope','CompanyInfoService', function($scope,CompanyInfoService) {
	$scope.state="department";
	$scope.left_state = "company_settings";
	$scope.collapsed = false;
}]);
