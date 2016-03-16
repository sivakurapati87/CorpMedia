'use strict';

App.controller('CompanyInfoController', ['$scope','CompanyInfoService','$stateParams', function($scope,CompanyInfoService,$stateParams) {
	 var self = this;
	 alert($stateParams.legEntity);
              $scope.selectedCompany=null;
              $scope.companyInfo=[];
          //Json for the auto complete
          self.getCompanyInfoInit = function(){
        	 
//        	  $scope.$watch(function () { return  HomeService.getSelectedCompany(); }, function (newValue, oldValue) {
//      	        if (newValue != null) {
//      	            //update Controller2's xxx value
//      	            $scope.selectedCompany=newValue;
//      	          CompanyInfoService.getCompanyInfo($scope.selectedCompany)
//             	 .then(
//     				       function(d) {
//     				    	 $scope.companyInfo = d;
//     				       },
//       					function(errResponse){
//       						console.error('Error while fetching Currencies');
//       					}
//     		       );
//      	        }
//      	    }, true);
//        	  CompanyInfoService.getSelectedCompany()
//         	 .then(
// 				       function(d) {
//				    	  $scope.selectedCompany=d.selectedCompName;
// 				    	 CompanyInfoService.getCompanyInfo($scope.selectedCompany)
// 			          	 .then(
// 			  				       function(d) {
// 			  				    	 $scope.companyInfo = d;
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
        	  
        	  
        	 
        	 
          };
          self.getCompanyInfoInit();
          
}]);
