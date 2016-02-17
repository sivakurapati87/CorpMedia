'use strict';

App.controller('job_titles_Controller', ['$scope','$location','$rootScope','CompanyInfoService','$stateParams', function($scope,$location,$rootScope,CompanyInfoService,$stateParams) {
	 var self = this;
	 $scope.state="job_titles";
		$scope.left_state = "employee";
		
//		$scope.state_info_name = $stateParams.legEntity;
//		$scope.$parent.state_info_name = $stateParams.legEntity;
//        $scope.selectedCompany=null;
//        $scope.companyInfo=[];
//      
//          //Json for the auto complete
//          self.getCompanyInfoInit = function(){
//        	 
////        	  $scope.$watch(function () { return  HomeService.getSelectedCompany(); }, function (newValue, oldValue) {
////      	        if (newValue != null) {
////      	            //update Controller2's xxx value
////      	            $scope.selectedCompany=newValue;
////      	          CompanyInfoService.getCompanyInfo($scope.selectedCompany)
////             	 .then(
////     				       function(d) {
////     				    	 $scope.companyInfo = d;
////     				       },
////       					function(errResponse){
////       						console.error('Error while fetching Currencies');
////       					}
////     		       );
////      	        }
////      	    }, true);
//        	  CompanyInfoService.getSelectedCompany()
//         	 .then(
// 				       function(d) {
//				    	  $scope.selectedCompany=d.selectedCompName;
// 				    	 CompanyInfoService.getCompanyInfo($scope.selectedCompany)
// 			          	 .then(
// 			  				       function(d) {
// 			  				    	 $scope.companyInfo = d;
// 			  				    	 $scope.$parent.companyName = d[0].companyName;
// 			  				    	$rootScope.companyName = d[0].companyName;
// 			  				    	$rootScope.companyId = d[0].companyId;
// 			  				       },
// 			    					function(errResponse){
// 			    						console.error('Error while fetching Currencies');
// 			    					}
// 			  		       );
// 				       },
//   					function(errResponse){
//   						console.error('Error while fetching Currencies');
//   					}
// 		       );
//        	  
//        	  
//        	 
//        	 
//          };
//          self.getCompanyInfoInit();
		
		
		
		
		
          


          

          
}]);
