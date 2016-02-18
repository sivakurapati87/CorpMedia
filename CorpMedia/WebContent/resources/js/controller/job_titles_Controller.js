'use strict';

App.controller('job_titles_Controller', ['$scope','$location','$rootScope','$http','$stateParams', function($scope,$location,$rootScope,$http,$stateParams) {
	 var self = this;
	 $scope.state="job_titles";
		$scope.left_state = "employee";
		$scope.collapsed = false;
		$scope.jobtitles = {};
		
		
		//Save jobtitles
		$scope.saveJobTitles = function(){
			alert($rootScope.selectedCompanyObj.companyId);
			if($rootScope.selectedCompanyObj){
				$scope.jobtitles.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.JobTitlesController+'/saveJobTitles', $scope.jobtitles).success(function(data) {
	        }).error(function() {
	      	  console.error('Could not save or update jobtitles');
	        });}
		};
		

		
		
		
		
          


          

          
}]);
