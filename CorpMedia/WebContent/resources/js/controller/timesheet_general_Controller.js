'use strict';

App.controller('timesheet_general_Controller', ['$scope','$location','$rootScope','$http', function($scope,$location,$rootScope,$http) {
	 var self = this;
	 $scope.state="timesheet_general";
		$scope.left_state = "timesheet";
		$scope.generalSettingsJson = {};
		
		//Save New Bank
		$scope.saveTimeSheet_GeneralInfo = function(){
			if($rootScope.selectedCompanyObj){
				$scope.generalSettingsJson.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.GeneralSettingsController+'/saveGeneralSettings', $scope.generalSettingsJson).success(function(data) {
	        }).error(function() {
	      	  console.error('Could not save or update saveTimeSheet_GeneralInfo');
	        });}
		};
		
		
          


          

          
}]);
