'use strict';

App.controller('Company_Locations_Controller', ['$scope','CompanyInfoService', function($scope,CompanyInfoService) {
	$scope.state="locations";
	$scope.left_state = "company_settings";
}]);
