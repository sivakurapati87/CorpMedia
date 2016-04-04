'use strict';

App.controller('HomeController', ['$scope','$http','$state', function($scope,$http,$state) {
	 $scope.loading = true;
	 var self = this;
	 $scope.selectedCompany=null;
	 $scope.companies=[];
	 
        //getting the selected companyId from auto complete
          $scope.selectedCompanyAction = function(selected) {
              if (selected) {
            	  $scope.selectedCompany= selected.title;
            		$scope.companyId = selected.description.companyId;
            	  
            	  if($scope.companyId){
          			$http.get(constants.localhost_port+"/"+constants.web_context+'/'+constants.CompanyInfoController+'/setSelectedCompanyId/'+ $scope.companyId).success(function(data) {
          				
          			}).error(function() {
          	      	  console.error('Could not save selected companyId');
          	        });}
            	  
              } else {
                console.log('cleared');
              }
            };
            
          //getting the selected companyId from auto complete
            $scope.submitAction = function() {
            			$http.get(constants.localhost_port+"/"+constants.web_context+'/'+constants.CompanyInfoController+'/setSelectedCompanyId/'+ 3).success(function(data) {
            				$state.go("company_legalentities.mainInfo",{legEntity:'cmpInfo'});
            			}).error(function() {
            	      	  console.error('Could not save selected companyId');
            	        });
              };
}]);
