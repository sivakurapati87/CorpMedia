'use strict';

App.controller('timesheet_approval_chain_Controller', ['$scope','$location','$rootScope','$http','$stateParams', function($scope,$location,$rootScope,$http,$stateParams) {
	 var self = this;
	 $scope.state="timesheet_approval_chain";
		$scope.left_state = "timesheet";
		$scope.approverList = null;
		
		$scope.addApproverLevel = function(){
			//If list is empty
			if(!$scope.approverList){
			$scope.approverList = [{}];
			}else{
				$scope.approverList.push({});
			}
//			$http.post(constants.localhost_port+"/"+constants.web_context+'/'+constants.TimeSheetApprovalChainController+'/addApproverLevel', $scope.approverList).success(function(data) {
//	        $scope.approverList  = data;
//			}).error(function() {
//	         console.error('Could not save or update addNewSignatory');
//	        });
		};
		
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

