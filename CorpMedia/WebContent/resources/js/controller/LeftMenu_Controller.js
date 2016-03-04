'use strict';

App.controller('LeftMenu_Controller', ['$scope','$location','$rootScope','CompanyInfoService','$state', function($scope,$location,$rootScope,CompanyInfoService,$state) {
        	 
	$scope.init = function(){
		if(!$rootScope.companyName){
	CompanyInfoService.getSelectedCompany()
         	 .then(
 				       function(d) {
				    	  $scope.selectedCompany=d.selectedCompName;
 				    	 CompanyInfoService.getCompanyInfo($scope.selectedCompany)
 			          	 .then(
 			  				       function(d) {
 			  				    	 $scope.companyInfo = d;
 			  				    	 $scope.$parent.companyName = d[0].companyName;
 			  				    	$rootScope.companyName = d[0].companyName;
 			  				    	$rootScope.companyId = d[0].companyId;
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
		}
	};	  
        	  
        	$scope.leftMenuAction = function(sref,state){
        		$scope.left_state = state;
        		$state.go(sref);
        	} 
        	 $scope.init();
//          self.getCompanyInfoInit();
		
		
		
		
		
          


          

          
}]);
