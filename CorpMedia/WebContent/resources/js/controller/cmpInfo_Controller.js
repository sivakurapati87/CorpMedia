'use strict';

App.controller('cmpInfo_Controller', ['$scope','$http', '$rootScope','CompanyInfoService','$stateParams', function($scope,$http,$rootScope,CompanyInfoService,$stateParams) {
	 $scope.state="legalentities";
		$scope.left_state = "company_settings";
		$scope.state_info_name = $stateParams.legEntity;
		$scope.$parent.state_info_name = $stateParams.legEntity;
        $scope.selectedCompany=null;
        $rootScope.companyInfo=[];
      
          //getting the lookup and company json object
          $scope.getCompanyInfoInit = function(){
        	  $http.get(constants.localhost_port+"/"+constants.web_context+'/'+constants.LookUpController+'/lookupInit').success(function(data){
		    	   	  if(data){
		    	   		$rootScope.lookup = data;
		    	   	  }
		    	     });
        	  
        	  $http.get(constants.localhost_port+"/"+constants.web_context+'/'+constants.CompanyInfoController+'/getSelectedCompanyId').success(function(data) {
    				if(data){
        		  $http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.CompanyController+'/getCompanyInfoByCompanyId/'+data.companyId).success(function(result){
  		    	   	  if(result){
  		    	   		$rootScope.selectedCompanyObj = result;
  		    	   		$rootScope.companyId = result.companyId;
  		    	   		$rootScope.companyName = result.companyName;
  		    	   	  }
  		    	     });}
    			}).error(function() {
    	      	  console.error('Could not get the company Info');
    	        });
          };
          $scope.getCompanyInfoInit();
          


          

          
}]);
