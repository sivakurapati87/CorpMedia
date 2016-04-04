'use strict';

App.controller('Company_General_Controller', ['$scope','$rootScope','$http', function($scope,$rootScope,$http) {
	$scope.state="general";  
	$scope.left_state = "company_settings";
	$scope.isProcessing = true;
	
	//save or update Company General Info
	$scope.saveCompanyGeneralInfo = function(){
		$scope.isProcessing = true;
		if($scope.companyJson){
			if($scope.companyLogo){
				$scope.companyJson.base64logo = $scope.companyLogo;
			}
		$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.CompanyController+'/saveCompanyGeneralInfo', $scope.companyJson).success(function(data) {
		}).error(function() {
      	  console.error('Could not save or update Company General Info');
        });}
		$scope.isProcessing = false;
	};
	
	$scope.fileChanged = function(e) {  
		  
		  var files = e.target.files;
		  $scope.isProcessing = true;
		 
		   var fileReader = new FileReader();
		  fileReader.readAsDataURL(files[0]);  
		  
		  fileReader.onload = function(e) {
			  $scope.companyLogo = this.result;
		   $scope.$apply();
		   $scope.isProcessing = false;
		  };
		 };
		 
		 
		 $scope.init = function(){
			 $scope.isProcessing = true;
			 $scope.companyJson = {};
			 if($rootScope.selectedCompanyObj){
				 $scope.companyJson.companyId = $rootScope.selectedCompanyObj.companyId;
				 $scope.companyJson.base64logo = $rootScope.selectedCompanyObj.base64logo;
				 $scope.companyJson.shortName = $rootScope.selectedCompanyObj.shortName;
			 }
			 $scope.isProcessing = false;
		 }
		 $scope.init();
}]);
