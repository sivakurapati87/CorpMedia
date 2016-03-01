'use strict';

App.controller('billing_rates_Controller', ['$scope','$location','$rootScope','$http','$stateParams', function($scope,$location,$rootScope,$http,$stateParams) {
	 var self = this;
	 $scope.state="billing_rates";
		$scope.left_state = "project";
		
		$scope.billingrates = {};
		
		//Save billingrates
		$scope.saveBillingRates = function(){
			alert($rootScope.selectedCompanyObj.companyId);
			if($rootScope.selectedCompanyObj){
				$scope.billingrates.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.BillingRatesController+'/saveBillingRates', $scope.billingrates).success(function(data) {
	        }).error(function() {
	      	  console.error('Could not save or update billingrates');
	        });}
		};

		
		
          


          

          
}]);
