'use strict';

App.controller('employee_professional_Controller', ['$scope','$location','$rootScope','$http','$stateParams', function($scope,$location,$rootScope,$http,$stateParams) {
	 var self = this;
	 $scope.state="employee_professional";
		$scope.left_state = "employee";
		$scope.employeeProfessionalInfoJson = {};
		$scope.employeeEducationalInfoJson = {};
		$scope.employeeExperienceInfoJson = {};
		$scope.isExpCollapse = true;//To hide and display the experience block
		$scope.isEduCollapse = true;
		$scope.isProcessing = true;
		
		//Save/update employee Professional Info
		$scope.saveOrUpdateEmployeeProfessionalInfo = function(){
			if($rootScope.selectedCompanyObj){
				$scope.isProcessing = true;
				$scope.employeeProfessionalInfoJson.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.EmployeeController+'/saveOrUpdateEmployeeProfessionalInfo', $scope.employeeProfessionalInfoJson).success(function(data) {
//				$scope.employeeProfessionalInfoJson = {};
				$scope.isProcessing = false;
			}).error(function() {
	      	  console.error('Could not save or update Employee Professional Info');
	        });}
		};
		
		//This function is to save experience information
		$scope.saveOrUpdateEmployeeExperienceInfo = function(){
			$scope.isProcessing = true;
			if($scope.employeeExperienceInfoJson.strFromDate){//converting the date format
				$scope.employeeExperienceInfoJson.strFromDate = $scope.formatteddate($scope.employeeExperienceInfoJson.strFromDate);
			}
			if($scope.employeeExperienceInfoJson.strToDate){//converting the date format
				$scope.employeeExperienceInfoJson.strToDate = $scope.formatteddate($scope.employeeExperienceInfoJson.strToDate);
			}
			if($rootScope.selectedCompanyObj){
				$scope.employeeExperienceInfoJson.companyId = $rootScope.selectedCompanyObj.companyId;
				$scope.employeeExperienceInfoJson.employeeId = $scope.employeeProfessionalInfoJson.employeeId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.EmployeeController+'/saveOrUpdateEmployeeExperienceInfo', $scope.employeeExperienceInfoJson).success(function(data) {
				$scope.isExpCollapse = true;
				$scope.getEmployeeExperienceInfo();
				$scope.employeeExperienceInfoJson = {};
				$scope.isProcessing = false;
			}).error(function() {
	      	  console.error('Could not save or update Employee Experience Info');
	        });}
		};
		
		//This function is to save educational information
		$scope.saveOrUpdateEmployeeEducationalInfo = function(){
			$scope.isProcessing = true;
			if($scope.employeeEducationalInfoJson.strFromDate){//converting the date format
				$scope.employeeEducationalInfoJson.strFromDate = $scope.formatteddate($scope.employeeEducationalInfoJson.strFromDate);
			}
			if($scope.employeeEducationalInfoJson.strToDate){//converting the date format
				$scope.employeeEducationalInfoJson.strToDate = $scope.formatteddate($scope.employeeEducationalInfoJson.strToDate);
			}
			if($rootScope.selectedCompanyObj){
				$scope.employeeEducationalInfoJson.companyId = $rootScope.selectedCompanyObj.companyId;
				$scope.employeeEducationalInfoJson.employeeId = $scope.employeeProfessionalInfoJson.employeeId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.EmployeeController+'/saveOrUpdateEmployeeEducationalInfo', $scope.employeeEducationalInfoJson).success(function(data) {
//				$scope.isCollapse = true;
				$scope.employeeEducationalInfoJson = {};
				$scope.isEduCollapse = true;
				$scope.getEmployeeEducationalInfo();
				$scope.isProcessing = false;
			}).error(function() {
	      	  console.error('Could not save or update Employee Experience Info');
	        });}
		};
		
		//This is to formate dates
		 $scope.formatteddate = function(date){
	      	  var expDate = new Date(date);
	      	 var month = '' + (expDate.getMonth() + 1);
	           var day = '' + expDate.getDate();
	          var  year = expDate.getFullYear();
	      	  if (month.length < 2) month = '0' + month;
	      	    if (day.length < 2) day = '0' + day;
	      	    return [year, month, day].join('-');
	        };
	        
	    	// get all the Employees list
			$scope.getAllEmployeesList = function(){
				$scope.isProcessing = true;
				if($rootScope.selectedCompanyObj){
				$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.EmployeeController+'/getAllEmployeesByCompanyId/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
					$scope.EmployeeJsonList = data;
					$scope.employeeProfessionalInfoJson.employeeId = $rootScope.empObj.employeeId;
					$scope.onChangeEmployeeId();
					$scope.isProcessing = false;
				}).error(function() {
		      	  console.error('Could not get All Employees List');
		        });}
			};
			
			//onchange employee combo box
			$scope.onChangeEmployeeId = function(){
				angular.forEach($scope.EmployeeJsonList, function(obj, key){
					if(obj.employeeId == $scope.employeeProfessionalInfoJson.employeeId){
					$scope.employeeJson = obj;
					}
		          });
				$scope.getEmployeeProfessionalInfo();//getting employee personal info
				$scope.getEmployeeExperienceInfo();//getting employee family info
				$scope.getEmployeeEducationalInfo();//getting educational info
			}
			
			//This function is to get all the employee experience list
			$scope.getEmployeeExperienceInfo = function(){
				if($scope.employeeProfessionalInfoJson.employeeId){
				$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.EmployeeController+'/getEmployeeExperienceInfo/'+ $scope.employeeProfessionalInfoJson.employeeId).success(function(data) {
					$scope.EmployeeExperienceJsonList = data;
				}).error(function() {
		      	  console.error('Could not get All Employee Experience List');
		        });}
			};
			
			//This function is to get all the employee educational info list
			$scope.getEmployeeEducationalInfo = function(){
				$scope.isProcessing = true;
				if($scope.employeeProfessionalInfoJson.employeeId){
				$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.EmployeeController+'/getEmployeeEducationalInfo/'+ $scope.employeeProfessionalInfoJson.employeeId).success(function(data) {
					$scope.EmployeeEducationalJsonList = data;
					$scope.isProcessing = false;
				}).error(function() {
		      	  console.error('Could not get All Employee Educational List');
		        });}
			};
			
			//This function is to get the professional information of an employee
			$scope.getEmployeeProfessionalInfo = function(){
				if($scope.employeeProfessionalInfoJson.employeeId){
				$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.EmployeeController+'/getEmployeeProfessionalInfo/'+ $scope.employeeProfessionalInfoJson.employeeId).success(function(data) {
					if(data){
					$scope.employeeProfessionalInfoJson = data;
					}else{
//						$scope.employeeProfessionalInfoJson = {};
					}
					$scope.employeeProfessionalInfoJson.employeeId = $scope.employeeJson.employeeId;//assigning employee Id
				}).error(function() {
		      	  console.error('Could not get Employee Professional Information');
		        });}
			};
			
			
			// This function is to edit experience information
			$scope.editExperienceInfo = function(employeeExperienceInfoJson){
				$scope.employeeExperienceInfoJson = employeeExperienceInfoJson;
				$scope.isExpCollapse = false;
			};
			
			//delete employee experience information
			$scope.deleteEmployeeExperienceInfo = function(employeeExperienceId){
				$scope.isProcessing = true;
				$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.EmployeeController+'/deleteEmployeeExperienceInfo/'+ employeeExperienceId).success(function(data) {
					$scope.getEmployeeExperienceInfo();
					$scope.isProcessing = false;
				}).error(function() {
		      	  console.error('Could not deleteEmployee Family Info');
		        });
			};
			
			
			
			
			// cancel employee educational information
			$scope.cancelExpInfo = function() {
				$scope.isExpCollapse = true;
			};
			

			// This function is to edit educational information
			$scope.editEducationalInfo = function(employeeEducationalInfoJson){
				$scope.employeeEducationalInfoJson = employeeEducationalInfoJson;
				$scope.isEduCollapse = false;
			};
			
			// delete employee educational information
			
			$scope.deleteEmployeeEducationalInfo = function(employeeEducationalId){
				$scope.isProcessing = true;
				$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.EmployeeController+'/deleteEmployeeEducationalInfo/'+ employeeEducationalId).success(function(data) {
					$scope.getEmployeeEducationalInfo();
					$scope.isProcessing = false;
				}).error(function() {
		      	  console.error('Could not deleteEmployee educational Info');
		        });
			};
			
			// cancel employee educational information
			$scope.cancelEduInfo = function() {
				$scope.isEduCollapse = true;
			};
			
			
//			$scope.getEmployeeEducationalInfo();
//			$scope.getEmployeeExperienceInfo();
			
			$scope.getAllEmployeesList();
			
}]);
