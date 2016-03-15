'use strict';

App.controller('HomeController', ['$scope','HomeService', function($scope,HomeService) {
	 $scope.loading = true;
	 var self = this;
	 $scope.selectedCompany=null;
	 $scope.companies=[];
        //set the selected contry
          $scope.selectedCompanyAction = function(selected) {
              if (selected) {
            	  $scope.selectedCompany= selected.title;
            	  HomeService.insertSelectedCompany($scope.selectedCompany);
            	  
              } else {
                console.log('cleared');
              }
            };

            
            
            var currentDate = moment();
    	    
            var fnWeekDays = function(dt) {

               var currentDate = dt;
               var weekStart = currentDate.clone().startOf('week');
               var weekEnd = currentDate.clone().endOf('week');

               var days = [],i;
               for (i = 0; i <= 6; i++) {

                   days.push(moment(weekStart).add(i, 'days').format("MMMM Do,dddd"));

               };
               return days;
           }
           
           $scope.weekDays = fnWeekDays(currentDate);
           $scope.nextWeek = function(dt) {
               $scope.weekDays = fnWeekDays(moment(dt, "MMMM Do,dddd").add(1, 'days'));
           };
           $scope.previousWeek = function(dt) {
               $scope.weekDays = fnWeekDays(moment(dt, "MMMM Do,dddd").subtract(1, 'days'));
           };
          
              
              
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
