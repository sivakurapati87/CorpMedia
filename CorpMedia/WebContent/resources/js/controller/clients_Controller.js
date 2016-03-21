'use strict';

App.controller('clients_Controller', ['$scope','$location','$rootScope','$http','$stateParams', function($scope,$location,$rootScope,$http,$stateParams) {
	 var self = this;
	 $scope.state="clients";
		$scope.left_state = "project";
		$scope.isCollapse = true;
		$scope.clients = {};
		$scope.isProcessing = true;
		
		
		//Save clients
		$scope.saveClients = function(){
			$scope.isProcessing = true;
			if($rootScope.selectedCompanyObj){
				$scope.clients.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.ClientsController+'/saveClients', $scope.clients).success(function(data) {
				$scope.getAllClientsList();
				$scope.clients = {};
				$scope.isProcessing = true;
	        }).error(function() {
	      	  console.error('Could not save or update clients');
	        });}
		};
		
		
		
		// get all clients list
		$scope.getAllClientsList = function(){
			$scope.isProcessing = true;
			if($rootScope.selectedCompanyObj){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.ClientsController+'/getAllClientsList/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
				$scope.clientsList = data;
				$scope.isProcessing = false;
			}).error(function() {
	      	  console.error('Could not getclientsList');
	        });}
		};
		
		// init
		$scope.getAllClientsList();
		
		
		//edit expenses
		$scope.editClients = function(clients) {
			$scope.clients = clients;
			$scope.isCollapse = false;
			
		};
		
		//delete clients
		$scope.deleteClients = function(clientsId){
			$scope.isProcessing = true;
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.ClientsController+'/deleteClients/'+ clientsId).success(function(data) {
				$scope.getAllClientsList();
				$scope.isProcessing = false;
			}).error(function() {
	      	  console.error('Could not deleteClients');
	        });
		};
		
		
//cancel
		
		$scope.cancelClients = function() {
			$scope.isCollapse = true;
		};
		
		
		
		
		
		
          


          

          
}]);
