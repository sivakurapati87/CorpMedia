'use strict';

App.controller('Company_Legalentities_Controller', ['$scope','$location','CompanyInfoService','$stateParams', function($scope,$location,CompanyInfoService,$stateParams) {
	$scope.state="legalentities";
	$scope.left_state = "company_settings";
	$scope.state_info_name = null;
	$scope.companyName= null;
	
//	$scope.logout = function () {
//		$location.path("/login");
//
//};
}]);
