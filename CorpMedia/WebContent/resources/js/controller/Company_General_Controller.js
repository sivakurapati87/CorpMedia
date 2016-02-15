'use strict';

App.controller('Company_General_Controller', ['$scope','CompanyInfoService', function($scope,CompanyInfoService) {
	$scope.state="general";  
	$scope.left_state = "company_settings";
}]);
