'use strict';

App.controller('reports_Controller', ['$scope','$location','$rootScope','$http','$stateParams', function($scope,$location,$rootScope,$http,$stateParams) {
	 var self = this;
	 $scope.state="reports";
		$scope.left_state = "project";
        $scope.reports = {};
        
      //This function is to save reports
		$scope.saveOrUpdateReports = function(){
			if($scope.reportsJson.strFromDate){//converting the date format
				$scope.reportsJson.strFromDate = $scope.formatteddate($scope.reportsJson.strFromDate);
			}
			if($scope.reportsJson.strToDate){//converting the date format
				$scope.reportsJson.strToDate = $scope.formatteddate($scope.reportsJson.strToDate);
			}
			if($rootScope.selectedCompanyObj){
				$scope.reportsJson.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.ReportsController+'/saveOrUpdateReports', $scope.reportsJson).success(function(data) {
				
				
				 
			}).error(function() {
	      	  console.error('Could not save or update reports');
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


          

          
}]);
