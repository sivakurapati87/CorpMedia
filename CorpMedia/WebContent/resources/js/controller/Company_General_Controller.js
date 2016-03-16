'use strict';

App.controller('Company_General_Controller', ['$scope','$rootScope','$http', function($scope,$rootScope,$http) {
	$scope.state="general";  
	$scope.left_state = "company_settings";
	
	//save or update Company General Info
	$scope.saveCompanyGeneralInfo = function(){
		if($scope.companyJson){
			if($scope.companyLogo){
				$scope.companyJson.base64logo = $scope.companyLogo;
			}
		$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.CompanyController+'/saveCompanyGeneralInfo', $scope.companyJson).success(function(data) {
		}).error(function() {
      	  console.error('Could not save or update Company General Info');
        });}
	};
	
	$scope.fileChanged = function(e) {  
		  
		  var files = e.target.files;
		 
		   var fileReader = new FileReader();
		  fileReader.readAsDataURL(files[0]);  
		  
		  fileReader.onload = function(e) {
			  $scope.companyLogo = this.result;
		   $scope.$apply();
		  };
		 };
		 
		 
		 $scope.init = function(){
			 $scope.companyJson = {};
			 if($rootScope.selectedCompanyObj){
				 $scope.companyJson.companyId = $rootScope.selectedCompanyObj.companyId;
				 $scope.companyJson.base64logo = $rootScope.selectedCompanyObj.base64logo;
				 $scope.companyJson.shortName = $rootScope.selectedCompanyObj.shortName;
			 }
		 }
		 $scope.init();
}]);
