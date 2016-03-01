'use strict';

App.controller('task_billing_Controller', ['$scope','$location','$rootScope','$http','$stateParams', function($scope,$location,$rootScope,$http,$stateParams) {
	 var self = this;
	 $scope.state="task_billing";
		$scope.left_state = "project";
		$scope.taskbilling = {};
		
		
		
		 //This function is to save task billing
		$scope.saveOrUpdateTaskBilling = function(){
			if($scope.taskBillingJson.strFromDate){//converting the date format
				$scope.taskBillingJson.strFromDate = $scope.formatteddate($scope.taskBillingJson.strFromDate);
			}
			if($scope.taskBillingJson.strToDate){//converting the date format
				$scope.taskBillingJson.strToDate = $scope.formatteddate($scope.taskBillingJson.strToDate);
			}
			if($rootScope.selectedCompanyObj){
				$scope.taskBillingJson.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.TaskBillingController+'/saveOrUpdateTaskBilling', $scope.taskBillingJson).success(function(data) {
				
				
				 
			}).error(function() {
	      	  console.error('Could not save or update taskbilling');
	        });}
		};
		
		
		//This is to format dates
		 $scope.formatteddate = function(date){
	      	  var expDate = new Date(date);
	      	 var month = '' + (expDate.getMonth() + 1);
	           var day = '' + expDate.getDate();
	          var  year = expDate.getFullYear();
	      	  if (month.length < 2) month = '0' + month;
	      	    if (day.length < 2) day = '0' + day;
	      	    return [year, month, day].join('-');
	        };


          


          
}]);
