'use strict';

App.controller('tags_Controller', ['$scope','$location','$rootScope','$http','$stateParams', function($scope,$location,$rootScope,$http,$stateParams) {
	 var self = this;
	 $scope.state="tags";
		$scope.left_state = "expenses";
		$scope.isCollapse = true;
		$scope.tags = {};
		$scope.isProcessing = true;
		
		
		//Save tags
		$scope.saveTags = function(){
			$scope.isProcessing = true;
			alert($rootScope.selectedCompanyObj.companyId);
			if($rootScope.selectedCompanyObj){
				$scope.tags.companyId = $rootScope.selectedCompanyObj.companyId;
			$http.post(constants.localhost_port+"/"+constants.service_context+'/'+constants.TagsController+'/saveTags', $scope.tags).success(function(data) {
				$scope.isProcessing = false;
				$scope.tags = {};
	        }).error(function() {
	      	  console.error('Could not save or update tags');
	        });}
		};
		
		
		// get all tags list
		$scope.getAllTagsList = function(){
			$scope.isProcessing = true;
			if($rootScope.selectedCompanyObj){
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.TagsController+'/getAllTagsList/'+ $rootScope.selectedCompanyObj.companyId).success(function(data) {
				$scope.tagsList = data;
				$scope.isProcessing = false;
			}).error(function() {
	      	  console.error('Could not getTagsList');
	        });}
		};
		$scope.getAllTagsList();
		
		
		//edit tags
		$scope.editTags = function(tags) {
			$scope.tags = tags;
			$scope.isCollapse = false;
			
		};
		
		
		//delete tags
		$scope.deleteTags = function(tagId){
			$scope.isProcessing = true;
			$http.get(constants.localhost_port+"/"+constants.service_context+'/'+constants.TagsController+'/deleteTags/'+ tagId).success(function(data) {
				$scope.getAllTagsList();
				$scope.isProcessing = false;
			}).error(function() {
	      	  console.error('Could not deleteTags');
	        });
		};
		
		
//cancel
		
		$scope.cancelTags = function() {
			$scope.isCollapse = true;
		};
}]);
