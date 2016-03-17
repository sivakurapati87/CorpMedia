'use strict';

App.controller('ptInfo_Controller', ['$scope','$location','$stateParams', function($scope,$location,$stateParams) {
	 $scope.state="legalentities";
		$scope.left_state = "company_settings";
		$scope.state_info_name = $stateParams.legEntity;
		$scope.$parent.state_info_name = $stateParams.legEntity;
}]);
