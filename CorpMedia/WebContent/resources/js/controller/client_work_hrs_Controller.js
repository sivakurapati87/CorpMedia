'use strict';

App.controller('client_work_hrs_Controller', ['$scope','$location','$rootScope','$http','$stateParams', function($scope,$location,$rootScope,$http,$stateParams) {
	 
	$scope.reports_state="client_work_hrs";
		$scope.left_state = "project";
		$scope.state = "reports";

		// get all clients list
		$scope.getAllClientsList = function(){
			if($rootScope.selectedCompanyObj){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.ClientsController+'/getAllClientsList/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
				$scope.clientsList = data;
			}).error(function() {
	      	  console.error('Could not getclientsList');
	        });}
		};
		
		// init
		$scope.getAllClientsList();
		
		
		$scope.clientworkhours={};
		// save client work hour s
		$scope.saveClientWorkHours = function(){
			if($rootScope.selectedCompanyObj){
				$scope.clientworkhours.strFrom = $scope.formatteddate($scope.clientworkhours.strFrom);
				$scope.clientworkhours.strTo = $scope.formatteddate($scope.clientworkhours.strTo);
				$scope.clientworkhours.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.ClientWorkHoursController+'/saveClientWorkHours/',$scope.clientworkhours).success(function(data) {
				$scope.getAllClientsList();
				$scope.clientworkhours = {};
			}).error(function() {
	      	  console.error('Could not getclientsList');
	        });}
		};
		
		
		// get all client Work Hrs list
		  $scope.getAllClientWorkHoursList = function(){
		   if($rootScope.selectedCompanyObj){
		   $http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.ClientWorkHoursController+'/getAllClientWorkHoursList/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
		    $scope.clientWorkHoursList = data;
		   }).error(function() {
		          console.error('Could not getclient Work Hours list');
		         });}
		  };
		  
		  // init
		  $scope.getAllClientWorkHoursList();
		  
		  // edit ClientWorkHours
		  $scope.editClientWorkHours = function(clientWHL ){
		   $scope.clientworkhours = clientWHL;
		   $scope.isExpCollapse = false;
		  };
		  
		  //delete Client Work Hour
		  $scope.deleteClientWorkHours= function(clientWorkHourId){
		   $http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.ClientWorkHoursController+'/deleteClientWorkHours/'+ clientWorkHourId).success(function(data) {
		    $scope.getAllClientWorkHoursList();
		   }).error(function() {
		          console.error('Could not delete client work hours');
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
}]);
