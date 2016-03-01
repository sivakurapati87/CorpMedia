'use strict';

App.controller('clients_Controller', ['$scope','$location','$rootScope','$http','$stateParams', function($scope,$location,$rootScope,$http,$stateParams) {
	 var self = this;
	 $scope.state="clients";
		$scope.left_state = "project";
		$scope.isCollapse = true;
		$scope.clients = {};
		
		
		//Save clients
		$scope.saveClients = function(){
			alert($rootScope.selectedCompanyObj.companyId);
			if($rootScope.selectedCompanyObj){
				$scope.clients.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.ClientsController+'/saveClients', $scope.clients).success(function(data) {
				$scope.getAllClientsList();
				$scope.clients = {};
	        }).error(function() {
	      	  console.error('Could not save or update clients');
	        });}
		};
		
		
		
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
		
		
		//edit expenses
		$scope.editClients = function(clients) {
			$scope.clients = clients;
			$scope.isCollapse = false;
			
		};
		
		//delete clients
		$scope.deleteClients = function(clientsId){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.ClientsController+'/deleteClients/'+ clientsId).success(function(data) {
				$scope.getAllClientsList();
			}).error(function() {
	      	  console.error('Could not deleteClients');
	        });
		};
		
		
//cancel
		
		$scope.cancelClients = function() {
			$scope.isCollapse = true;
		};
		
		
		
		
		
		
          


          

          
}]);
