'use strict';

App.controller('timing_policies_Controller', ['$scope','$location','$rootScope','$stateParams', function($scope,$location,$rootScope,$stateParams) {
	 $scope.state="timing_policies";
		$scope.left_state = "time_&_attendance";
		$scope.isProcessing = false;
}]);
