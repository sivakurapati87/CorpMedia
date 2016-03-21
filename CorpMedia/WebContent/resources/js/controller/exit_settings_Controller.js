'use strict';

App.controller('exit_settings_Controller', ['$scope','$location','$rootScope','$http','$stateParams', function($scope,$location,$rootScope,$http,$stateParams) {
	 var self = this;
	 $scope.state="exit_settings";
		$scope.left_state = "onboarding_&_exit";
		$scope.exitsettings = {};
		$scope.isProcessing = true;
		
		//Save exit settings
		$scope.saveExitSettings = function(){
			$scope.isProcessing = true;
			alert($rootScope.selectedCompanyObj.companyId);
			if($rootScope.selectedCompanyObj){
				$scope.exitsettings.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.ExitSettingsController+'/saveExitSettings', $scope.exitsettings).success(function(data) {
				$scope.getAllExitSettingsList();
				$scope.exitsettings = {};
				$scope.isProcessing = false;
	        }).error(function() {
	      	  console.error('Could not save or update exitsettings');
	        });}
		};
		
		// get exit settings list
		$scope.getAllExitSettingsList = function(){
			$scope.isProcessing = true;
			if($rootScope.selectedCompanyObj){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.ExitSettingsController+'/getAllExitSettingsList/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
				$scope.exitSettingsList = data;
				$scope.isProcessing = false;
			}).error(function() {
	      	  console.error('Could not getAllExitSettingsList');
	        });}
		};
		
		// init 
		$scope.getAllExitSettingsList();
		
		//edit  exit settings
		$scope.editExitSettings = function(exitsettings) {
			$scope.exitsettings = exitsettings;
			
			
		};
		
		//delete  exit settings
		$scope.deleteExitSettings = function(exitSettingsId){
			$scope.isProcessing = true;
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.ExitSettingsController+'/deleteExitSettings/'+ exitSettingsId).success(function(data) {
				$scope.getAllExitSettingsList();
				$scope.isProcessing = false;
			}).error(function() {
	      	  console.error('Could not deleteExitSettings');
	        });
		};
          

          
}]);
