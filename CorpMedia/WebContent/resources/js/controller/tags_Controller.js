'use strict';

App.controller('tags_Controller', ['$scope','$location','$rootScope','$http','$stateParams', function($scope,$location,$rootScope,$http,$stateParams) {
	 var self = this;
	 $scope.state="tags";
		$scope.left_state = "expenses";
		$scope.collapsed = false;
		$scope.tags = {};
		
		
		//Save tags
		$scope.saveTags = function(){
			alert($rootScope.selectedCompanyObj.companyId);
			if($rootScope.selectedCompanyObj){
				$scope.tags.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.TagsController+'/saveTags', $scope.tags).success(function(data) {
	        }).error(function() {
	      	  console.error('Could not save or update tags');
	        });}
		};
}]);
