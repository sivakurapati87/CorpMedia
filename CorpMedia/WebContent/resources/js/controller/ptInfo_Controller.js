'use strict';

App.controller('ptInfo_Controller', ['$scope','$location','CompanyInfoService','$stateParams', function($scope,$location,CompanyInfoService,$stateParams) {
	 $scope.state="legalentities";
		$scope.left_state = "company_settings";
		$scope.state_info_name = $stateParams.legEntity;
		$scope.$parent.state_info_name = $stateParams.legEntity;
}]);
