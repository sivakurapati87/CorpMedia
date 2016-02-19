'use strict';

App.controller('cmpInfo_Controller', ['$scope','$http', '$rootScope','CompanyInfoService','$stateParams', function($scope,$http,$rootScope,CompanyInfoService,$stateParams) {
	 var self = this;
	 $scope.state="legalentities";
		$scope.left_state = "company_settings";
		$scope.state_info_name = $stateParams.legEntity;
		$scope.$parent.state_info_name = $stateParams.legEntity;
        $scope.selectedCompany=null;
        $scope.companyInfo=[];
      
          //Json for the auto complete
          self.getCompanyInfoInit = function(){
        	 
        	  CompanyInfoService.getSelectedCompany()
         	 .then(
 				       function(d) {
 				    	   //Inserting the all lookup
 				    	  $http.get(constants.localhost_port+"/"+constants.web_context+'/'+constants.LookUpController+'/lookupInit').success(function(data){
 				    	   	  if(data){
 				    	   		$rootScope.lookup = data;
 				    	   	  }
 				    	     });
 				    	   
 				    	   
				    	  $scope.selectedCompany=d.selectedCompName;
 				    	 CompanyInfoService.getCompanyInfo($scope.selectedCompany)
 			          	 .then(
 			  				       function(d) {
 			  				    	 $scope.companyInfo = d;
 			  				    	 $scope.$parent.companyName = d[0].companyName;
 			  				    	$rootScope.companyName = d[0].companyName;
 			  				    	$rootScope.companyId = d[0].companyId;
 			  				    	$rootScope.selectedCompanyObj = d[0];
 			  				       },
 			    					function(errResponse){
 			    						console.error('Error while fetching Currencies');
 			    					}
 			  		       );
 				       },
   					function(errResponse){
   						console.error('Error while fetching Currencies');
   					}
 		       );
          };
          self.getCompanyInfoInit();
          


          

          
}]);
