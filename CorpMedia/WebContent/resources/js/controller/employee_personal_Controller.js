'use strict';

App.controller('employee_personal_Controller', ['$scope','$location','$rootScope','$http','$stateParams', function($scope,$location,$rootScope,$http,$stateParams) {
	 var self = this;
	 	$scope.state="employee_personal";
		$scope.left_state = "employee";
		$scope.employeePersonalInfoJson = {};
		$scope.employeeFamilyInfoJson = {};
		$scope.isCollapse = true;//To hide and display the address block
		
		
		//Save/update employee Personal Info
		$scope.saveOrUpdateEmployeePersonalInfo = function(){
			$scope.formatteddate();
			if($rootScope.selectedCompanyObj){
				$scope.employeePersonalInfoJson.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.EmployeeController+'/saveOrUpdateEmployeePersonalInfo', $scope.employeePersonalInfoJson).success(function(data) {
//				$scope.employeePersonalInfoJson = {};
			}).error(function() {
	      	  console.error('Could not save or update EmployeePersonalInfo');
	        });}
		};
		
		//This function is to save family information
		$scope.saveOrUpdateEmployeeFamilyInfo = function(){
			if($rootScope.selectedCompanyObj){
				$scope.employeeFamilyInfoJson.companyId = $rootScope.selectedCompanyObj.companyId;
				$scope.employeeFamilyInfoJson.employeeId = $scope.employeePersonalInfoJson.employeeId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.EmployeeController+'/saveOrUpdateEmployeeFamilyInfo', $scope.employeeFamilyInfoJson).success(function(data) {
				$scope.isCollapse = true;
				$scope.getAllEmployeeFamilyList();
				$scope.employeeFamilyInfoJson = {};
			}).error(function() {
	      	  console.error('Could not save or update Employee Family Info');
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
					$scope.employeePersonalInfoJson.employeeId = $rootScope.empObj.employeeId;
					$scope.onChangeEmployeeId();
				}).error(function() {
		      	  console.error('Could not get All Employees List');
		        });}
			};
			
			//onchange employee combo box
			$scope.onChangeEmployeeId = function(){
				angular.forEach($scope.EmployeeJsonList, function(obj, key){
					if(obj.employeeId == $scope.employeePersonalInfoJson.employeeId){
					$scope.employeeJson = obj;
					}
		          });
				$scope.getEmployeePersonalInfo();//getting employee personal info
				$scope.getAllEmployeeFamilyList();//getting employee family info
			}
			
			//This function is to get all the employee family list
			$scope.getAllEmployeeFamilyList = function(){
				if($scope.employeePersonalInfoJson.employeeId){
				$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.EmployeeController+'/getAllEmployeeFamilyList/'+ $scope.employeePersonalInfoJson.employeeId).success(function(data) {
					$scope.EmployeeFamilyJsonList = data;
				}).error(function() {
		      	  console.error('Could not get All Employee Family List');
		        });}
			};
			
			//This function is to get the personal information of an employee
			$scope.getEmployeePersonalInfo = function(){
				if($scope.employeePersonalInfoJson.employeeId){
				$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.EmployeeController+'/getEmployeePersonalInfo/'+ $scope.employeePersonalInfoJson.employeeId).success(function(data) {
					if(data){
					$scope.employeePersonalInfoJson = data;
					}else{
						$scope.employeePersonalInfoJson = {};
					}
					$scope.employeePersonalInfoJson.employeeId = $scope.employeeJson.employeeId;//assigning employee Id
				}).error(function() {
		      	  console.error('Could not get Employee Personal Information');
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
			
			// This function is to edit family information
			$scope.editFamilyInfo = function(employeeFamilyInfoJson){
				$scope.employeeFamilyInfoJson = employeeFamilyInfoJson;
				$scope.isCollapse = false;
			};
			
			//delete companylocation
			$scope.deleteEmployeeFamilyInfo = function(employeeFamilyInfoId){
				$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.EmployeeController+'/deleteEmployeeFamilyInfo/'+ employeeFamilyInfoId).success(function(data) {
					$scope.getAllJobTitlesList();
				}).error(function() {
		      	  console.error('Could not deleteEmployee Family Info');
		        });
			};
			
			$scope.getAllEmployeesList();
			
			//cancel
			$scope.cancelFamilyInfo = function() {
				$scope.isCollapse = true;
			};
			
}]);
