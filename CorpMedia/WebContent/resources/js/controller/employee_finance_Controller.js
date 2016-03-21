'use strict';

App.controller('employee_finance_Controller', ['$scope','$state','$rootScope','$http', function($scope,$state,$rootScope,$http) {
	 	$scope.state="employee_finance";
		$scope.left_state = "employee";
		$scope.employeeSalaryInfoJson = {};	
		$scope.employeeOneTimeComponentJson = {};
		$scope.isProcessing = false;
		
		//This function is to save employee salary info
		$scope.saveOrUpdateEmployeeSalaryInfo = function(){
			if($rootScope.selectedCompanyObj){
				$scope.employeeSalaryInfoJson.strEffectiveFrom = $scope.formatteddate($scope.employeeSalaryInfoJson.strEffectiveFrom);
				$scope.employeeSalaryInfoJson.companyId = $rootScope.selectedCompanyObj.companyId;
				$scope.employeeSalaryInfoJson.employeeId = $rootScope.empObj.employeeId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.EmployeeController+'/saveOrUpdateEmployeeSalaryInfo', $scope.employeeSalaryInfoJson).success(function(data) {
				$scope.getEmployeeSalaryInfo();
				 $('#mySalaryModelPopupId').modal('hide');
			}).error(function() {
	      	  console.error('Could not save or update Employee Family Info');
	        });}
		};
		//This is to formate dates
		 $scope.formatteddate = function(inputDate){
	      	  var inDate = new Date(inputDate);
	      	 var month = '' + (inDate.getMonth() + 1);
	           var day = '' + inDate.getDate();
	          var  year = inDate.getFullYear();
	      	  if (month.length < 2) month = '0' + month;
	      	    if (day.length < 2) day = '0' + day;
	      	    return [year, month, day].join('-');
	        };
	        
	    	// get the employee Salary Info
			$scope.getEmployeeSalaryInfo = function(){
				if($rootScope.empObj){
				$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.EmployeeController+'/getEmployeeSalaryInfo/'+  $rootScope.empObj.employeeId).success(function(data) {
					$scope.employeeSalaryInfoJson = data;
				}).error(function() {
		      	  console.error('Could not get Employee Salary Info');
		        });}
			};
			
			//This function is to save employee salary info
			$scope.saveOrUpdateEmployeeOneTimeComponent = function(){
				if($rootScope.selectedCompanyObj){
					$scope.employeeOneTimeComponentJson.strMonthPayable = $scope.formatteddate($scope.employeeOneTimeComponentJson.strMonthPayable);
					$scope.employeeOneTimeComponentJson.companyId = $rootScope.selectedCompanyObj.companyId;
					$scope.employeeOneTimeComponentJson.employeeId = $rootScope.empObj.employeeId;
				$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.EmployeeController+'/saveOrUpdateEmployeeOneTimeComponent', $scope.employeeOneTimeComponentJson).success(function(data) {
					$scope.getEmployeeSalaryInfo();
					$scope.employeeOneTimeComponentJson = {};
//					 $('#oneTimeComponentModelpopupid').modal('hide');
				}).error(function() {
		      	  console.error('Could not save or update Employee One Time Component Info');
		        });}
			};
			
			//Edit employee one time component
			$scope.editOneTimeComponent = function(employeeOneTimeComponentJson){
				$scope.employeeOneTimeComponentJson = employeeOneTimeComponentJson;
			}
			
			//delete One Time Component
			$scope.deleteOneTimeComponent = function(employeeOneTimeComponentId){
				$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.EmployeeController+'/deleteEmployeeOneTimeComponent/'+ employeeOneTimeComponentId).success(function(data) {
					$scope.getEmployeeSalaryInfo();
				}).error(function() {
		      	  console.error('Could not deleteOneTimeComponent');
		        });
			};
			
			
			//This is to formate dates
			 $scope.formatteddate = function(inputDate){
		      	  var inDate = new Date(inputDate);
		      	 var month = '' + (inDate.getMonth() + 1);
		           var day = '' + inDate.getDate();
		          var  year = inDate.getFullYear();
		      	  if (month.length < 2) month = '0' + month;
		      	    if (day.length < 2) day = '0' + day;
		      	    return [year, month, day].join('-');
		        };
		        
		    	// get the employee Salary Info
				$scope.getEmployeeOneTimeComponent = function(){
					if($rootScope.empObj){
					$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.EmployeeController+'/getEmployeeOneTimeComponent/'+  $rootScope.empObj.employeeId).success(function(data) {
						$scope.employeeOneTimeComponentJsonList = data;
					}).error(function() {
			      	  console.error('Could not get Employee One Time Component Info');
			        });}
				};
			
			// This function is to find the value of monthly
			$scope.findMonthlyAmount = function(amount){
				return Math.round(amount/12);
			}
			
			//init
			$scope.getEmployeeSalaryInfo();
//			$scope.getEmployeeOneTimeComponent();
}]);
