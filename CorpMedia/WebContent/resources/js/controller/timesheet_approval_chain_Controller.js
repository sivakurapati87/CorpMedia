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
		
		
		
		
          


          

          
}]);

