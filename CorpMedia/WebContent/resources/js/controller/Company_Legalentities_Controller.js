'use strict';

App.controller('Company_Legalentities_Controller', ['$rootScope','$http','$scope','$location','CompanyInfoService','$stateParams', function($rootScope,$http,$scope,$location,CompanyInfoService,$stateParams) {
	$scope.state="legalentities";
	$scope.left_state = "company_settings";
	$scope.state_info_name = null;
	$scope.companyName= null;
	
	$scope.signator = {};
	
	//save new signatory
	$scope.addNewSignatory = function(){
		if($rootScope.selectedCompanyObj){
			$scope.signator.companyId = $rootScope.selectedCompanyObj.companyId;
		$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.COMP_SIGNATOR+'/saveSignatory', $scope.signator).success(function(data) {
      	  if(data){
      		 $('#addSignatoryPopupId').modal('hide');
      		$scope.signator = {};
      	  }else{
      		  //This is to display the error message
//      		  angular.element('#erroPopupId').trigger('click');
      	  }
        }).error(function() {
      	  console.error('Could not save or update addNewSignatory');
        });}
	};
	$scope.init = function(){
		if(!$scope.banksList){
	 $http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.LookUpController+'/getAllBanks').success(function(data){
   	  if(data){
   		$scope.banksList = data;
   		$scope.selectBank=null;
   	  }
     });
	 }};
     $scope.init();
}]);
