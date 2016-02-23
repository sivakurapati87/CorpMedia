'use strict';

App.controller('employee_personal_Controller', ['$scope','$location','$rootScope','$http','$stateParams', function($scope,$location,$rootScope,$http,$stateParams) {
	 var self = this;
	 $scope.state="employee_personal";
		$scope.left_state = "employee";
	$scope.employeePersonalInfoJson = {};
	$scope.isCollapse = true;//To hide and display the address block
		//Save/update employee
		$scope.saveOrUpdateEmployeePersonalInfo = function(){
			alert('');
			$scope.formatteddate();
			if($rootScope.selectedCompanyObj){
				$scope.employeePersonalInfoJson.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.EmployeeController+'/saveOrUpdateEmployeePersonalInfo', $scope.employeePersonalInfoJson).success(function(data) {
				$scope.employeePersonalInfoJson = {};
			}).error(function() {
	      	  console.error('Could not save or update EmployeePersonalInfo');
	        });}
		};
		//This is to formate dates
		 $scope.formatteddate = function(){
	      	  var expDate = new Date($scope.employeePersonalInfoJson.strDateOfBirth);
	      	 var month = '' + (expDate.getMonth() + 1);
	           var day = '' + expDate.getDate();
	          var  year = expDate.getFullYear();
	      	  if (month.length < 2) month = '0' + month;
	      	    if (day.length < 2) day = '0' + day;
	      	    $scope.employeePersonalInfoJson.strDateOfBirth =  [year, month, day].join('-');
	        };
	        
	    	// get all the Employees list
			$scope.getAllEmployeesList = function(){
				if($rootScope.selectedCompanyObj){
				$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.EmployeeController+'/getAllEmployeesByCompanyId/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
					$scope.EmployeeJsonList = data;
				}).error(function() {
		      	  console.error('Could not get All Employees List');
		        });}
			};
			
			// if permanent is same as current
			$scope.isPermanentSameAsCurrent = function(){
				if($scope.employeePersonalInfoJson.isPermSameAsCurr){
					$scope.employeePersonalInfoJson.permAddress = $scope.employeePersonalInfoJson.currAddress;
					$scope.employeePersonalInfoJson.permCity = $scope.employeePersonalInfoJson.currCity;
					$scope.employeePersonalInfoJson.permState = $scope.employeePersonalInfoJson.currState;
					$scope.employeePersonalInfoJson.permCountry = $scope.employeePersonalInfoJson.currCountry;
				}
			};
			$scope.getAllEmployeesList();
}]);
