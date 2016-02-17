'use strict';

App.controller('Company_Locations_Controller', ['$scope','$http','$rootScope', function($scope,$http,$rootScope) {
	$scope.state="locations";
	$scope.left_state = "company_settings";
	$scope.companyLocationJson = {};
	
	//Save New Department
	$scope.saveDepartment = function(){
		if($rootScope.selectedCompanyObj){
			$scope.companyLocationJson.companyId = $rootScope.selectedCompanyObj.companyId;
		$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.CompanyLocationController+'/saveLocation', $scope.companyLocationJson).success(function(data) {
        }).error(function() {
      	  console.error('Could not save or update saveDepartment');
        });}
	};
}]);
