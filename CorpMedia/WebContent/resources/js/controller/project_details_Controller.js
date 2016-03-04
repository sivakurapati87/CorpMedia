'use strict';

App.controller('project_details_Controller', ['$scope','$location','$rootScope','$http','$stateParams', function($scope,$location,$rootScope,$http,$stateParams) {
	 var self = this;
	 $scope.state="project_details";
		$scope.left_state = "project";
		$scope.projectdetails = {};
		
		
		 //This function is to save project details
		$scope.saveOrUpdateProjectDetails = function(){
			if($scope.projectDetailsJson.strFromDate){//converting the date format
				$scope.projectDetailsJson.strFromDate = $scope.formatteddate($scope.projectDetailsJson.strFromDate);
			}
			if($scope.projectDetailsJson.strToDate){//converting the date format
				$scope.projectDetailsJson.strToDate = $scope.formatteddate($scope.projectDetailsJson.strToDate);
			}
			if($rootScope.selectedCompanyObj){
				$scope.projectDetailsJson.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.ProjectDetailsController+'/saveOrUpdateProjectDetails', $scope.projectDetailsJson).success(function(data) {
				
				
				 
			}).error(function() {
	      	  console.error('Could not save or update projectdetails');
	        });}
		};
		
		
		//This is to format dates
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
