'use strict';

App.controller('timesheet_general_Controller', ['$scope','$location','$rootScope','$http', function($scope,$location,$rootScope,$http) {
	 var self = this;
	 $scope.state="timesheet_general";
		$scope.left_state = "timesheet";
		$scope.generalSettingsJson = {};
		$scope.isProcessing = true;
		
		//Save New Bank
		$scope.saveTimeSheet_GeneralInfo = function(){
			$scope.isProcessing = true;
			if($rootScope.selectedCompanyObj){
				$scope.generalSettingsJson.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.GeneralSettingsController+'/saveGeneralSettings', $scope.generalSettingsJson).success(function(data) {
				$scope.getCompanyGeneralSetting();
				$scope.isProcessing = false;
			}).error(function() {
	      	  console.error('Could not save or update saveTimeSheet_GeneralInfo');
	        });}
		};
		// get all the approvers list
		$scope.getCompanyGeneralSetting = function(){
			$scope.isProcessing = true;
			if($rootScope.selectedCompanyObj){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.GeneralSettingsController+'/getCompanyGeneralSetting/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
				$scope.generalSettingsJson = data;
				$scope.isProcessing = false;
			}).error(function() {
	      	  console.error('Could not getCompanyGeneralSetting');
	        });}
		};


		$scope.getCompanyGeneralSetting();
		
          


          

          
}]);
