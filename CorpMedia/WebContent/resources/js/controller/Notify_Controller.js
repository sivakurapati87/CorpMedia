'use strict';

App.controller('Notify_Controller', ['$scope','$location','$rootScope','$http', function($scope,$location,$rootScope,$http) {
	 var self = this;
	 $scope.state="notify";
		$scope.left_state = "leaves_&_holidays";
		$scope.isProcessing = true;
		
		
		//save Holiday
		$scope.addNotify = function(){
			if($rootScope.selectedCompanyObj){
				$scope.leavesNotifyJson.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.NotifyController+'/addNotify', $scope.leavesNotifyJson).success(function(data) {
				$scope.leavesNotifyJson = {};
				$('#addSignatoryPopupId').modal('hide');
				$scope.$broadcast('angucomplete-alt:clearInput');//To clear the angu complete values
				$scope.getAllLeaveNotifiersList();
			}).error(function() {
	      	  console.error('Could not saveHoliday');
	        });}
		};
	          
		// get all company leave type
		$scope.getAllLeaveNotifiersList = function(){
			$scope.isProcessing = true;
			if($rootScope.selectedCompanyObj){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.NotifyController+'/getAllNotifiersList/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
				$scope.notifiesList = data;
				$scope.getFinalEmployeeList();
				$scope.isProcessing = false;
			}).error(function() {
	      	  console.error('Could not getAllCompanyLeaveTypeList');
	        });}
		};
	          
		
		
		//delete delete Holiday
		$scope.deleteNotify = function(leavesNotifyId){
			$scope.isProcessing = true;
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.NotifyController+'/deleteNotify/'+ leavesNotifyId).success(function(data) {
				$scope.getAllLeaveNotifiersList();
				$scope.isProcessing = false;
			}).error(function() {
	      	  console.error('Could not delete Notify');
	        });
		};
		
	    //This function is to get the selected document from auto population
        $scope.selectedEmployeeIdAction = function(selected) {
            if (selected) {
          	$scope.leavesNotifyJson.notifyEmpId = selected.description.employeeId;
            } else {
              console.log('cleared');
            }
          };
    
       // get all the Employees list
  		$scope.getAllEmployeesList = function(){
  			$scope.isProcessing = true;
  			if($rootScope.selectedCompanyObj){
  			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.EmployeeController+'/getAllEmployeesByCompanyId/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
  				$scope.EmployeeJsonList = data;
  				$scope.getAllLeaveNotifiersList();
  				$scope.isProcessing = false;
  			}).error(function() {
  	      	  console.error('Could not get All Employees List');
  	        });}
  		};
		
  	//Get the auto complete employee list
		$scope.getFinalEmployeeList = function(){
			$scope.autoCompleteEmpList = [{}];
			$scope.autoCompleteEmpList.splice(0,1);
					angular.forEach($scope.EmployeeJsonList, function(o, k)
    				  {
						var flag=false;
						angular.forEach($scope.notifiesList, function(obj, key)
	    				  {
							if(obj.notifyEmpId == o.employeeId){
							flag = true;
							}
	    				  });
						if(!flag && $scope.autoCompleteEmpList.indexOf(o) === -1){
							$scope.autoCompleteEmpList.push(o);
						}
		           	     });
			
		};
		
  		
			//init
	        $scope.init = function(){
	        	$scope.leavesNotifyJson = {};
	        	$scope.getAllEmployeesList();
	        };
	        $scope.init();


          

          
}]);
