'use strict';

App.controller('HomeController', ['$scope','HomeService', function($scope,HomeService) {
	 $scope.loading = true;
	 var self = this;
	 $scope.selectedCompany=null;
	 $scope.companies=[];
        //set the selected contry
          $scope.selectedCompanyAction = function(selected) {
              if (selected) {
//            	  alert(selected.title);
            	  $scope.selectedCompany= selected.title;
//            	  HomeService.setSelectedCompany($scope.selectedCompany);
            	  HomeService.insertSelectedCompany($scope.selectedCompany);
            	  
//            	  $scope.$watch(function () { return  HomeService.getSelectedCompany(); }, function (newValue, oldValue) {
//            	        if (newValue != null) {
//            	            //update Controller2's xxx value
//            	            alert(newValue);
//            	        }
//            	    }, true);
              } else {
                console.log('cleared');
              }
            };

          
          //Search Action
//            self.searchAction = function() {
//        	 HomeService.searchAction($scope.selectedCompany)
//        	 .then(
//				       function(d) {
//				       },
//					function(errResponse){
//						console.error('Error while fetching Currencies');
//					}
//		       );
//          };
          
              
              
          //Json for the auto complete
          self.findAllContries = function(){
        	 
        	 HomeService.contriesList()
        	 .then(
				       function(d) {
				    	   angular.copy(d, $scope.companies);
				       },
  					function(errResponse){
  						console.error('Error while fetching Currencies');
  					}
		       );
        	 
          };
          self.findAllContries();
          
}]);
