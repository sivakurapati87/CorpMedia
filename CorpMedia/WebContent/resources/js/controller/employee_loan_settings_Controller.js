'use strict';

App.controller('employee_loan_settings_Controller', ['$scope','$location','$rootScope','$stateParams', function($scope,$location,$rootScope,$stateParams) {
	 $scope.state="employee_loan_settings";
		$scope.left_state = "payroll";
		$scope.isProcessing = false;
}]);
