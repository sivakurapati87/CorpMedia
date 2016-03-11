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
			alert( $rootScope.selectedCompanyObj.companyId);
			if($rootScope.selectedCompanyObj){
				$scope.clientworkhours.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.ClientWorkHoursController+'/saveClientWorkHours/',$scope.clientworkhours).success(function(data) {
				$scope.getAllClientsList();
				$scope.clientworkhours = {};
			}).error(function() {
	      	  console.error('Could not getclientsList');
	        });}
		};
		
}]);
